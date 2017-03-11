/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slavko.baze2.procesnabavke.gui.db;

import slavko.baze2.procesnabavke.gui.domen.PoslovniPartner;
import slavko.baze2.procesnabavke.gui.domen.Proizvod;
import slavko.baze2.procesnabavke.gui.domen.Faktura;
import slavko.baze2.procesnabavke.gui.domen.NačinPlaćanja;
import slavko.baze2.procesnabavke.gui.domen.PDVStopa;
import slavko.baze2.procesnabavke.gui.domen.StavkaFakture;
import slavko.baze2.procesnabavke.gui.domen.Zaposleni;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sun.security.rsa.RSACore;

/**
 *
 * @author Slavko
 */
public class DBBroker {

    private Connection connection;

    public void ucitajDriver() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new Exception("Neuspesno ucitavanje drivera!", ex);
        }
    }

    public void otvoriKonekciju() throws Exception {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/ps_projekat", "root", "");
            connection.setAutoCommit(false);
            // Zahteva eksplicitnu potvrdu transakcije
        } catch (SQLException ex) {
            throw new Exception("Neuspesno otvaranje konekcije!", ex);
        }
    }

    public void commitTransakcije() throws Exception {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan commit transakcije!", ex);
        }
    }

    public void rollbackTransakcije() throws Exception {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan rollback transakcije!", ex);
        }
    }

    public void zatvoriKonekciju() throws Exception {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new Exception("Neuspesno zatvaranje konekcije!", ex);
        }
    }

    public List<Faktura> vratiFakture() throws Exception {
        try {
            List<Faktura> lf = new ArrayList<>();
            String sql = "SELECT * FROM faktura";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                Long fakturaID = rs.getLong(1);
                String brojFakture = rs.getString(2);
                Date datumFakturisanja = rs.getDate(3);
                Date rok = rs.getDate(4);
                Double ukupanIznos = rs.getDouble(5);
                Double ukupanPorez = rs.getDouble(6);
                String napomena = rs.getString(7);
                Boolean kompletirana = rs.getBoolean(8);
                Long zaposleniID = rs.getLong(9);
                Long nacinPlacanjaID = rs.getLong(10);
                Long poslovniPatnerID = rs.getLong(11);
                Zaposleni zaposleni = null;
                if (zaposleniID != null) {
                    zaposleni = vratiZaposlenog(zaposleniID);
                }
                NačinPlaćanja načinPlaćanja = null;
                if (nacinPlacanjaID != null) {
                    načinPlaćanja = vratiNačinPlaćanja(nacinPlacanjaID);
                }
                PoslovniPartner poslovniPartner = null;
                if (poslovniPatnerID != null) {
                    poslovniPartner = vratiPoslovnogParntera(poslovniPatnerID);
                }
                Faktura faktura = new Faktura(fakturaID, brojFakture, datumFakturisanja, rok, ukupanIznos, ukupanPorez, napomena, kompletirana, new ArrayList<>(), načinPlaćanja, poslovniPartner, zaposleni);

                String sqlStavke = "SELECT * from stavka_fakture where faktura_id=?";
                PreparedStatement sqlStatementStavke = connection.prepareStatement(sqlStavke);
                sqlStatementStavke.setLong(1, faktura.getFakturaID());
                ResultSet rsStavke = sqlStatementStavke.executeQuery();
                while (rsStavke.next()) {
                    Integer redniBroj = rsStavke.getInt(2);
                    Integer kolicina = rsStavke.getInt(3);
                    Double jediničnaCena = rsStavke.getDouble(4);
                    Double pdv = rsStavke.getDouble(5);
                    Double prodajnaVrednost = rsStavke.getDouble(6);
                    Long proizvodID = rsStavke.getLong(7);
                    Proizvod proizvod = null;
                    //if (proizvodID != 0) {
                    System.out.println(proizvodID);
                        proizvod = vratiProizvod(proizvodID);
                        System.out.println(proizvod);
                   // }
                    StavkaFakture stavkaFakture = new StavkaFakture(redniBroj, kolicina, jediničnaCena, pdv, prodajnaVrednost, proizvod);
                    faktura.getStavke().add(stavkaFakture);
                }
                lf.add(faktura);
                rsStavke.close();
                sqlStatementStavke.close();
            }
            rs.close();
            sqlStatement.close();
            return lf;
        } catch (SQLException ex) {
            throw new Exception("Sistem ne može da nađe listu faktura", ex);
        }
    }

    public void sacuvajFakturu(Faktura faktura) throws Exception {
        try {
            String sqlFaktura = "INSERT INTO faktura (broj_fakture,datum_fakturisanja,rok,ukupan_iznos,ukupan_porez,napomena,kompletirana,zaposleni_id,nacin_placanja_id,poslovni_partner_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement sqlStatementRacun = connection.prepareStatement(sqlFaktura, Statement.RETURN_GENERATED_KEYS);
            sqlStatementRacun.setString(1, faktura.getBrojFakture());
            if (faktura.getDatumFakturisanja() != null) {
                sqlStatementRacun.setDate(2, new java.sql.Date(faktura.getDatumFakturisanja().getTime()));
            } else {
                sqlStatementRacun.setNull(2, Types.DATE);
            }
            if (faktura.getRok() != null) {
                sqlStatementRacun.setDate(3, new java.sql.Date(faktura.getRok().getTime()));
            } else {
                sqlStatementRacun.setNull(3, Types.DATE);
            }

            sqlStatementRacun.setDouble(4, faktura.getUkupanIznos());
            sqlStatementRacun.setDouble(5, faktura.getUkupanPorez());
            sqlStatementRacun.setString(6, faktura.getNapomena());
            sqlStatementRacun.setBoolean(7, faktura.getKompletirana());
            if (faktura.getZaposleni() != null) {
                sqlStatementRacun.setLong(8, faktura.getZaposleni().getZaposleniID());
            } else {
                sqlStatementRacun.setNull(8, Types.BIGINT);
            }
            if (faktura.getNačinPlaćanja() != null) {
                sqlStatementRacun.setLong(9, faktura.getNačinPlaćanja().getNačinPlaćanjaID());
            } else {
                sqlStatementRacun.setNull(9, Types.BIGINT);
            }
            if (faktura.getPoslovniPartner() != null) {
                sqlStatementRacun.setLong(10, faktura.getPoslovniPartner().getPoslovniPartnerID());
            } else {
                sqlStatementRacun.setNull(10, Types.BIGINT);
            }
            sqlStatementRacun.executeUpdate();
            long fakturaID = -1l;
            ResultSet rs = sqlStatementRacun.getGeneratedKeys();
            if (rs != null && rs.next()) {
                fakturaID = rs.getLong(1);
            }

            String sqlStavka = "INSERT INTO stavka_fakture VALUES (?,?,?,?,?)";
            for (StavkaFakture s : faktura.getStavke()) {
                PreparedStatement sqlStatementStavka = connection.prepareStatement(sqlStavka);
                sqlStatementStavka.setLong(1, fakturaID);
                sqlStatementStavka.setInt(2, s.getRedniBroj());
                sqlStatementStavka.setInt(3, s.getKoličina());
                sqlStatementStavka.setDouble(4, s.getJediničnaCena());
                sqlStatementStavka.setDouble(5, s.getPdv());
                sqlStatementStavka.setDouble(6, s.getProdajnaVrednost());
                if (s.getProizvod() != null) {
                    sqlStatementStavka.setLong(7, s.getProizvod().getProizvodID());
                }
                sqlStatementStavka.executeUpdate();
                sqlStatementStavka.close();
            }
            sqlStatementRacun.close();
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da kreira novu fakturu", ex);
        }
    }

    public void izmeniFakturu(Faktura faktura) throws Exception {
        try {
            String sqlFaktura = "UPDATE faktura set datum_fakturisanja=?,rok=?,ukupan_iznos=?,ukupan_porez=?,napomena=?,kompletirana=?,zaposleni_id=?,nacin_placanja_id=?,poslovni_partner_id=? where faktura_id=?";
            PreparedStatement sqlStatementFaktura = connection.prepareStatement(sqlFaktura);

            if (faktura.getDatumFakturisanja() != null) {
                sqlStatementFaktura.setDate(1, new java.sql.Date(faktura.getDatumFakturisanja().getTime()));
            } else {
                sqlStatementFaktura.setNull(1, Types.DATE);
            }
            if (faktura.getRok() != null) {
                sqlStatementFaktura.setDate(2, new java.sql.Date(faktura.getRok().getTime()));
            } else {
                sqlStatementFaktura.setNull(2, Types.DATE);
            }

            sqlStatementFaktura.setDouble(3, faktura.getUkupanIznos());
            sqlStatementFaktura.setDouble(4, faktura.getUkupanPorez());
            sqlStatementFaktura.setString(5, faktura.getNapomena());
            sqlStatementFaktura.setBoolean(6, faktura.getKompletirana());

            if (faktura.getZaposleni() != null) {
                sqlStatementFaktura.setLong(7, faktura.getZaposleni().getZaposleniID());
            } else {
                sqlStatementFaktura.setNull(7, Types.BIGINT);
            }
            if (faktura.getNačinPlaćanja() != null) {
                sqlStatementFaktura.setLong(8, faktura.getNačinPlaćanja().getNačinPlaćanjaID());
            } else {
                sqlStatementFaktura.setNull(8, Types.BIGINT);
            }
            if (faktura.getPoslovniPartner() != null) {
                sqlStatementFaktura.setLong(9, faktura.getPoslovniPartner().getPoslovniPartnerID());
            } else {
                sqlStatementFaktura.setNull(9, Types.BIGINT);
            }

            sqlStatementFaktura.setLong(10, faktura.getFakturaID());
            sqlStatementFaktura.executeUpdate();

            String sqlDeleteStavke = "DELETE FROM stavka_fakture where faktura_id=?";
            PreparedStatement sqlStatementDeleteStavka = connection.prepareStatement(sqlDeleteStavke);
            sqlStatementDeleteStavka.setLong(1, faktura.getFakturaID());
            sqlStatementDeleteStavka.executeUpdate();
            sqlStatementDeleteStavka.close();

            String sqlStavka = "INSERT INTO stavka_fakture VALUES (?,?,?,?,?,?,?)";

            for (StavkaFakture s : faktura.getStavke()) {
                PreparedStatement sqlStatementStavka = connection.prepareStatement(sqlStavka);
                sqlStatementStavka.setLong(1, faktura.getFakturaID());
                sqlStatementStavka.setInt(2, s.getRedniBroj());
                sqlStatementStavka.setInt(3, s.getKoličina());
                sqlStatementStavka.setDouble(4, s.getJediničnaCena());
                sqlStatementStavka.setDouble(5, s.getPdv());
                sqlStatementStavka.setDouble(6, s.getProdajnaVrednost());
                if (s.getProizvod() != null) {
                    sqlStatementStavka.setLong(7, s.getProizvod().getProizvodID());
                }
                sqlStatementStavka.executeUpdate();
                sqlStatementStavka.close();
            }

            sqlStatementFaktura.close();
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da zapamti fakturu", ex);
        }
    }

    public void obrisiFakturu(Faktura faktura) throws Exception {
        try {
            String sqlStavka = "DELETE from stavka_fakture where faktura_id=?";
            PreparedStatement sqlStatementStavka = connection.prepareStatement(sqlStavka);
            sqlStatementStavka.setLong(1, faktura.getFakturaID());
            sqlStatementStavka.executeUpdate();
            sqlStatementStavka.close();

            String sqlFaktura = "DELETE from faktura where faktura_id=?";
            PreparedStatement sqlStatementRacun = connection.prepareStatement(sqlFaktura);
            sqlStatementRacun.setLong(1, faktura.getFakturaID());
            sqlStatementRacun.executeUpdate();
            sqlStatementRacun.close();
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da obriše fakturu", ex);
        }
    }

    public Long vratiMaksIDFakture() throws Exception {
        try {
            Long maxID = 0l;
            String sql = "SELECT max(faktura_id) from faktura";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            if (rs.next()) {
                maxID = rs.getLong(1);
            }
            rs.close();
            sqlStatement.close();
            return maxID;
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da vrati maksimalni ID fakture!", ex);
        }
    }

    public List<NačinPlaćanja> vratiNačinePlaćanja() throws Exception {
        try {
            List<NačinPlaćanja> lnp = new ArrayList<>();
            String sql = "SELECT * from nacin_placanja";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                Long načinPlaćanjaId = rs.getLong(1);
                String naziv = rs.getString(2);
                NačinPlaćanja načinPlaćanja = new NačinPlaćanja(načinPlaćanjaId, naziv);
                lnp.add(načinPlaćanja);
            }
            rs.close();
            sqlStatement.close();
            return lnp;
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da vrati listu načina plaćanja", ex);
        }
    }

    public NačinPlaćanja vratiNačinPlaćanja(Long id) throws Exception {
        try {
            NačinPlaćanja načinPlaćanja = null;
            String sql = "SELECT * from nacin_placanja where nacin_placanja_id=?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setLong(1, id);
            ResultSet rs = sqlStatement.executeQuery();
            if (rs.next()) {
                Long načinPlaćanjaId = rs.getLong(1);
                String naziv = rs.getString(2);
                načinPlaćanja = new NačinPlaćanja(načinPlaćanjaId, naziv);
            }
            rs.close();
            sqlStatement.close();
            return načinPlaćanja;
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da vrati način plaćanja", ex);
        }
    }

    public List<PoslovniPartner> vratiPoslovnePartnere() throws Exception {
        try {
            List<PoslovniPartner> lpp = new ArrayList<>();
            String sql = "SELECT * from poslovni_partner";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                Long poslovniPartnerID = rs.getLong(1);
                String žiroRačun = rs.getString(2);
                String adresa = rs.getString(3);
                String telefon = rs.getString(4);
                String naziv = rs.getString(5);
                String tip = rs.getString(6);
                String jmbg = rs.getString(7);
                String pib = rs.getString(8);
                PoslovniPartner poslovniPartner = new PoslovniPartner(poslovniPartnerID, žiroRačun, adresa, telefon, naziv, tip, žiroRačun, jmbg, pib);
                lpp.add(poslovniPartner);
            }
            rs.close();
            sqlStatement.close();
            return lpp;
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da vrati listu poslovnih partnera", ex);
        }
    }

    public PoslovniPartner vratiPoslovnogParntera(Long id) throws Exception {
        try {
            PoslovniPartner poslovniPartner = null;
            String sql = "SELECT * from poslovni_partner where poslovni_partner_id=?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setLong(1, id);
            ResultSet rs = sqlStatement.executeQuery();
            if (rs.next()) {
                Long poslovniPartnerID = rs.getLong(1);
                String žiroRačun = rs.getString(2);
                String adresa = rs.getString(3);
                String telefon = rs.getString(4);
                String naziv = rs.getString(5);
                String tip = rs.getString(6);
                String jmbg = rs.getString(7);
                String pib = rs.getString(8);
                poslovniPartner = new PoslovniPartner(poslovniPartnerID, žiroRačun, adresa, telefon, naziv, tip, žiroRačun, jmbg, pib);
            }
            rs.close();
            sqlStatement.close();
            return poslovniPartner;
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da vrati poslovnog partnera", ex);
        }
    }

    public List<Zaposleni> vratiZaposlene() throws Exception {
        try {
            List<Zaposleni> lpp = new ArrayList<>();
            String sql = "SELECT * from zaposleni";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                Long zaposleniID = rs.getLong(1);
                String korisničkoIme = rs.getString(2);
                String šifra = rs.getString(3);
                String ime = rs.getString(4);
                String prezime = rs.getString(5);
                Zaposleni zaposleni = new Zaposleni(zaposleniID, korisničkoIme, šifra, ime, prezime);
                lpp.add(zaposleni);
            }
            rs.close();
            sqlStatement.close();
            return lpp;
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da vrati listu zaposlenih", ex);
        }
    }

    public Zaposleni vratiZaposlenog(Long id) throws Exception {
        try {
            Zaposleni zaposleni = null;
            String sql = "SELECT * from zaposleni where zaposleni_id = ?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setLong(1, id);
            ResultSet rs = sqlStatement.executeQuery();
            if (rs.next()) {
                Long zaposleniID = rs.getLong(1);
                String korisničkoIme = rs.getString(2);
                String šifra = rs.getString(3);
                String ime = rs.getString(4);
                String prezime = rs.getString(5);
                zaposleni = new Zaposleni(zaposleniID, korisničkoIme, šifra, ime, prezime);
            }
            rs.close();
            sqlStatement.close();
            return zaposleni;
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da vrati zaposlenog", ex);
        }
    }

    public List<PDVStopa> vratiPDVStope() throws Exception {
        try {
            List<PDVStopa> lps = new ArrayList<>();
            String sql = "SELECT * from pdv_stopa";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                Long pdvStopaID = rs.getLong(1);
                String naziv = rs.getString(2);
                Double procenat = rs.getDouble(3);
                PDVStopa pdvStopa = new PDVStopa(pdvStopaID, naziv, procenat);
                lps.add(pdvStopa);
            }
            rs.close();
            sqlStatement.close();
            return lps;
        } catch (SQLException ex) {
            throw new Exception("Sistem ne može da nađe listu PDV stopa", ex);
        }
    }

    public PDVStopa vratiPDVStopu(Long id) throws Exception {
        try {
            PDVStopa pdvStopa = null;
            String sql = "SELECT * from pdv_stopa where pdv_stopa_id=?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setLong(1, id);
            ResultSet rs = sqlStatement.executeQuery();
            if (rs.next()) {
                Long pdvStopaID = rs.getLong(1);
                String naziv = rs.getString(2);
                Double procenat = rs.getDouble(3);
                pdvStopa = new PDVStopa(pdvStopaID, naziv, procenat);
            }
            rs.close();
            sqlStatement.close();
            return pdvStopa;
        } catch (SQLException ex) {
            throw new Exception("Sistem ne može da nađe PDV stopu!", ex);
        }
    }

    public List<Proizvod> vratiProizvode() throws Exception {
        try {
            List<Proizvod> lp = new ArrayList<>();
            String sql = "SELECT * from proizvod";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                Long proizvodID = rs.getLong(1);
                String klasifikacioniBroj = rs.getString(2);
                String naziv = rs.getString(3);
                Double cenaBezPDVa = rs.getDouble(4);
                String mernaJedinica = rs.getString(5);
                Integer stanje = rs.getInt(6);
                Long pdvStopaID = rs.getLong(7);
                PDVStopa pdvStopa = vratiPDVStopu(pdvStopaID);
                Proizvod proizvod = new Proizvod(proizvodID, klasifikacioniBroj, naziv, cenaBezPDVa, mernaJedinica, stanje, pdvStopa);
                lp.add(proizvod);
            }
            rs.close();
            sqlStatement.close();
            return lp;
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da vrati listu proizvoda", ex);
        }
    }

    public Proizvod vratiProizvod(Long id) throws Exception {
        try {
            Proizvod proizvod = null;
            String sql = "SELECT * from proizvod where proizvod_id=?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setLong(1, id);
            ResultSet rs = sqlStatement.executeQuery();
            if (rs.next()) {
                Long proizvodID = rs.getLong(1);
                String klasifikacioniBroj = rs.getString(2);
                String naziv = rs.getString(3);
                Double cenaBezPDVa = rs.getDouble(4);
                String mernaJedinica = rs.getString(5);
                Integer stanje = rs.getInt(6);
                Long pdvStopaID = rs.getLong(7);
                PDVStopa pdvStopa = vratiPDVStopu(pdvStopaID);
                proizvod = new Proizvod(proizvodID, klasifikacioniBroj, naziv, cenaBezPDVa, mernaJedinica, stanje, pdvStopa);
            }
            rs.close();
            sqlStatement.close();
            return proizvod;
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da vrati proizvod", ex);
        }
    }

    public Long vratiMaksIDProizvoda() throws Exception {
        try {
            Long maxID = 0l;
            String sql = "SELECT max(proizvod_id) from proizvod";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            if (rs.next()) {
                maxID = rs.getLong(1);
            }
            rs.close();
            sqlStatement.close();
            return maxID;
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da vrati maskimalni ID proizvoda", ex);
        }
    }

    public void sacuvajProizvod(Proizvod p) throws Exception {
        try {
            String sql = "INSERT INTO proizvod(klasifikacioni_broj,naziv,cena_bez_pdv,merna_jedinica,stanje,pdv_stopa_id) VALUES (?,?,?,?,?,?)";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setString(1, p.getKlasifikacioniBroj());
            sqlStatement.setString(2, p.getNaziv());
            sqlStatement.setDouble(3, p.getCenaBezPDVa());
            sqlStatement.setString(4, p.getMernaJedinica());
            sqlStatement.setInt(5, p.getStanje());
            if (p.getPdvStopa() != null) {
                sqlStatement.setLong(6, p.getPdvStopa().getPDVStopaID());
            } else {
                sqlStatement.setNull(6, Types.BIGINT);
            }
            sqlStatement.executeUpdate();
            sqlStatement.close();
        } catch (SQLException ex) {
            throw new Exception("Sistem ne može da zapamti proizvod", ex);
        }
    }

    public void izmeniProizvod(Proizvod p) throws Exception {
        try {
            String sql = "update proizvod set klasifikacioni_broj=?,naziv=?,cena_bez_pdv=?,merna_jedinica=?,stanje=?,pdv_stopa_id=? where proizvod_id=?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setString(1, p.getKlasifikacioniBroj());
            sqlStatement.setString(2, p.getNaziv());
            sqlStatement.setDouble(3, p.getCenaBezPDVa());
            sqlStatement.setString(4, p.getMernaJedinica());
            sqlStatement.setInt(5, p.getStanje());
            if (p.getPdvStopa() != null) {
                sqlStatement.setLong(6, p.getPdvStopa().getPDVStopaID());
            } else {
                sqlStatement.setNull(6, Types.BIGINT);
            }
            sqlStatement.setLong(7, p.getProizvodID());
            sqlStatement.executeUpdate();
            sqlStatement.close();
        } catch (SQLException ex) {
            throw new Exception("Sistem ne može da zapamti proizvod", ex);
        }
    }

    public void obrisiProizvod(Proizvod p) throws Exception {
        try {
            String sqlProizvod = "DELETE from proizvod where proizvod_id=?";
            PreparedStatement sqlStatementRacun = connection.prepareStatement(sqlProizvod);
            sqlStatementRacun.setLong(1, p.getProizvodID());
            sqlStatementRacun.executeUpdate();
            sqlStatementRacun.close();
        } catch (SQLException ex) {
            throw new Exception("Sistem ne može da obriše proizvod", ex);
        }
    }
    
    public Zaposleni vratiZaposlenog(String korisničkoIme, String šifra) throws Exception {
        try {
            String sqlZaposleni = "select * from zaposleni where korisnicko_ime=? and sifra=?";
            PreparedStatement sqlStatement = connection.prepareStatement(sqlZaposleni);
            sqlStatement.setString(1, korisničkoIme);
            sqlStatement.setString(2, šifra);
            ResultSet rs = sqlStatement.executeQuery();
            Zaposleni zaposleni = null;
            if(rs.next()){
                Long zaposleniID = rs.getLong(1);
                String ime = rs.getString(4);
                String prezime = rs.getString(5);
                zaposleni = new Zaposleni(zaposleniID, korisničkoIme, šifra, ime, prezime);
            }
            sqlStatement.close();
            return zaposleni;
        } catch (SQLException ex) {
            throw new Exception("Sistem ne može da nađe zaposlenog sa zadatim kredencijalima", ex);
        }
    }

}

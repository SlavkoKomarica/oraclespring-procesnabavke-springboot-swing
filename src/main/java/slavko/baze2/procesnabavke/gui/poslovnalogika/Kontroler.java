/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slavko.baze2.procesnabavke.gui.poslovnalogika;

import slavko.baze2.procesnabavke.gui.db.DBBroker;
import slavko.baze2.procesnabavke.gui.domen.PoslovniPartner;
import slavko.baze2.procesnabavke.gui.domen.Proizvod;
import slavko.baze2.procesnabavke.gui.domen.Faktura;
import slavko.baze2.procesnabavke.gui.domen.NačinPlaćanja;
import slavko.baze2.procesnabavke.gui.domen.PDVStopa;
import slavko.baze2.procesnabavke.gui.domen.StavkaFakture;
import slavko.baze2.procesnabavke.gui.domen.Zaposleni;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.geometry.Pos;

/**
 *
 * @author Slavko
 */
public class Kontroler {

    private DBBroker dbBroker;
    private static Kontroler instance;
    private Map<String, Object> map;

    private Kontroler() {
        dbBroker = new DBBroker();
        map = new HashMap<>();
    }

    public static Kontroler vratiInstancu() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public List<Proizvod> vratiProizvode() throws Exception {
        dbBroker.ucitajDriver();
        dbBroker.otvoriKonekciju();
        List<Proizvod> lp = dbBroker.vratiProizvode();
        dbBroker.zatvoriKonekciju();
        return lp;

    }

    public void dodajProizvod(Proizvod p) throws Exception {
        dbBroker.ucitajDriver();
        dbBroker.otvoriKonekciju();
        dbBroker.sacuvajProizvod(p);
        dbBroker.commitTransakcije();
        p.setProizvodID(dbBroker.vratiMaksIDProizvoda());
        dbBroker.zatvoriKonekciju();
    }

    public void izmeniProizvod(Proizvod p) throws Exception {
        dbBroker.ucitajDriver();
        dbBroker.otvoriKonekciju();
        dbBroker.izmeniProizvod(p);
        dbBroker.commitTransakcije();
        dbBroker.zatvoriKonekciju();
    }

    public void obrisiProizvod(Proizvod p) throws Exception {
        dbBroker.ucitajDriver();
        dbBroker.otvoriKonekciju();
        dbBroker.obrisiProizvod(p);
        dbBroker.commitTransakcije();
        dbBroker.zatvoriKonekciju();
    }

    public List<Faktura> vratiFakture() throws Exception {
        dbBroker.ucitajDriver();
        dbBroker.otvoriKonekciju();
        List<Faktura> lf = dbBroker.vratiFakture();
        dbBroker.zatvoriKonekciju();
        return lf;

    }

    public void dodajFakturu(Faktura f) throws Exception {
        dbBroker.ucitajDriver();
        dbBroker.otvoriKonekciju();
        dbBroker.sacuvajFakturu(f);
        dbBroker.commitTransakcije();
        f.setFakturaID(dbBroker.vratiMaksIDFakture());
        dbBroker.zatvoriKonekciju();
    }

    public void izmeniFakturu(Faktura f) throws Exception {
        dbBroker.ucitajDriver();
        dbBroker.otvoriKonekciju();
        dbBroker.izmeniFakturu(f);        
        dbBroker.commitTransakcije();
        dbBroker.zatvoriKonekciju();
    }
    
    public void kompletirajFakturu(Faktura f) throws Exception{
        dbBroker.ucitajDriver();
        dbBroker.otvoriKonekciju();
        dbBroker.izmeniFakturu(f);
        for(StavkaFakture stavkaFakture: f.getStavke()){
            Proizvod p = stavkaFakture.getProizvod();
            p.setStanje(p.getStanje()-stavkaFakture.getKoličina());
            dbBroker.izmeniProizvod(p);
        }
        dbBroker.commitTransakcije();
        dbBroker.zatvoriKonekciju();
    }

    public void obrisiFakturu(Faktura f) throws Exception {
        dbBroker.ucitajDriver();
        dbBroker.otvoriKonekciju();
        dbBroker.obrisiFakturu(f);
        dbBroker.commitTransakcije();
        dbBroker.zatvoriKonekciju();
    }

    public List<NačinPlaćanja> vratiNačinePlaćanja() throws Exception {
        dbBroker.ucitajDriver();
        dbBroker.otvoriKonekciju();
        List<NačinPlaćanja> lnp = dbBroker.vratiNačinePlaćanja();
        dbBroker.zatvoriKonekciju();
        return lnp;
    }

    public List<PoslovniPartner> vratiPoslovnePartnere() throws Exception {
        dbBroker.ucitajDriver();
        dbBroker.otvoriKonekciju();
        List<PoslovniPartner> lpp = dbBroker.vratiPoslovnePartnere();
        dbBroker.zatvoriKonekciju();
        return lpp;
    }

    public List<PDVStopa> vratiListuPDVStopa() throws Exception {
        dbBroker.ucitajDriver();
        dbBroker.otvoriKonekciju();
        List<PDVStopa> lps = dbBroker.vratiPDVStope();
        dbBroker.zatvoriKonekciju();
        return lps;
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public void remove(String key) {
        map.remove(key);
    }

    public String generisiKlasBrojProizvoda() throws Exception {
        dbBroker.ucitajDriver();
        dbBroker.otvoriKonekciju();
        Long maxID = dbBroker.vratiMaksIDProizvoda();
        dbBroker.zatvoriKonekciju();
        return longToString(++maxID, 10);

    }
    
     public String generisiBrojFakture() throws Exception {
        dbBroker.ucitajDriver();
        dbBroker.otvoriKonekciju();
        Long maxID = dbBroker.vratiMaksIDFakture();
        dbBroker.zatvoriKonekciju();
        return longToString(++maxID, 10);

    }

    static String longToString(long num, int digits) {
        StringBuffer s = new StringBuffer(digits);
        int zeroes = digits - (int) (Math.log(num) / Math.log(10)) - 1;
        for (int i = 0; i < zeroes; i++) {
            s.append(0);
        }
        return s.append(num).toString();
    }
    
    public Zaposleni pronadjiZaposlenog(String korisničkoIme, String šifra) throws Exception {
        dbBroker.ucitajDriver();
        dbBroker.otvoriKonekciju();
        Zaposleni zaposleni = dbBroker.vratiZaposlenog(korisničkoIme, šifra);
        dbBroker.zatvoriKonekciju();
        return zaposleni;

    }
}

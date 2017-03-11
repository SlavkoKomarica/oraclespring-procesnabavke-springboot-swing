/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slavko.baze2.procesnabavke.gui.domen;

/**
 *
 * @author Slavko
 */
public class Zaposleni {
    private Long zaposleniID;
    private String korisničkoIme;
    private String šifra;
    private String ime;
    private String prezime;

    public Zaposleni() {
    }

    public Zaposleni(Long zaposleniID, String korisničkoIme, String šifra, String ime, String prezime) {
        this.zaposleniID = zaposleniID;
        this.korisničkoIme = korisničkoIme;
        this.šifra = šifra;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Long getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(Long zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public String getKorisničkoIme() {
        return korisničkoIme;
    }

    public void setKorisničkoIme(String korisničkoIme) {
        this.korisničkoIme = korisničkoIme;
    }

    public String getŠifra() {
        return šifra;
    }

    public void setŠifra(String šifra) {
        this.šifra = šifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }
    
    
}

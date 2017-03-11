/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slavko.baze2.procesnabavke.gui.domen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Slavko
 */
public class Faktura {
    private Long fakturaID;
    private String brojFakture;
    private Date datumFakturisanja;
    private Date rok;
    private Double ukupanIznos = 0d;
    private Double ukupanPorez = 0d;
    private String napomena;
    private Boolean kompletirana = false;
    private List<StavkaFakture> stavke = new ArrayList<>();
    private NačinPlaćanja načinPlaćanja;
    private PoslovniPartner poslovniPartner;
    private Zaposleni zaposleni;

    public Faktura() {
        stavke = new ArrayList<>();
    }

    public Faktura(Long fakturaID, String brojFakture, Date datumFakturisanja, Date rok, Double ukupanIznos, Double ukupanPorez, String napomena, Boolean kompletirana, List<StavkaFakture> stavke, NačinPlaćanja načinPlaćanja, PoslovniPartner poslovniPartner, Zaposleni zaposleni) {
        this.fakturaID = fakturaID;
        this.brojFakture = brojFakture;
        this.datumFakturisanja = datumFakturisanja;
        this.rok = rok;
        this.ukupanIznos = ukupanIznos;
        this.ukupanPorez = ukupanPorez;
        this.napomena = napomena;
        this.kompletirana = kompletirana;
        this.stavke = stavke;
        this.načinPlaćanja = načinPlaćanja;
        this.poslovniPartner = poslovniPartner;
        this.zaposleni = zaposleni;
    }

    public Long getFakturaID() {
        return fakturaID;
    }

    public void setFakturaID(Long fakturaID) {
        this.fakturaID = fakturaID;
    }

    public String getBrojFakture() {
        return brojFakture;
    }

    public void setBrojFakture(String brojFakture) {
        this.brojFakture = brojFakture;
    }

    public Date getDatumFakturisanja() {
        return datumFakturisanja;
    }

    public void setDatumFakturisanja(Date datumFakturisanja) {
        this.datumFakturisanja = datumFakturisanja;
    }

    public Date getRok() {
        return rok;
    }

    public void setRok(Date rok) {
        this.rok = rok;
    }

    public Double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(Double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Double getUkupanPorez() {
        return ukupanPorez;
    }

    public void setUkupanPorez(Double ukupanPorez) {
        this.ukupanPorez = ukupanPorez;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Boolean getKompletirana() {
        return kompletirana;
    }

    public void setKompletirana(Boolean kompletirana) {
        this.kompletirana = kompletirana;
    }

    public List<StavkaFakture> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaFakture> stavke) {
        this.stavke = stavke;
    }

    public NačinPlaćanja getNačinPlaćanja() {
        return načinPlaćanja;
    }

    public void setNačinPlaćanja(NačinPlaćanja načinPlaćanja) {
        this.načinPlaćanja = načinPlaćanja;
    }

    public PoslovniPartner getPoslovniPartner() {
        return poslovniPartner;
    }

    public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
        this.poslovniPartner = poslovniPartner;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }       
}

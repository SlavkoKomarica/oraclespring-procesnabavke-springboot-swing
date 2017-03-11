/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slavko.baze2.procesnabavke.gui.domen;

import java.util.Objects;

/**
 *
 * @author Slavko
 */
public class PoslovniPartner {

    private Long poslovniPartnerID;
    private String žiroRačun;
    private String adresa;
    private String telefon;
    private String naziv;
    private String tip;
    private String jmbg;
    private String pib;

    public PoslovniPartner() {
    }

    public PoslovniPartner(Long poslovniPartnerID, String žiroRačun, String adresa, String telefon, String naziv, String tip, String ziroRacun, String jmbg, String pib) {
        this.poslovniPartnerID = poslovniPartnerID;
        this.žiroRačun = žiroRačun;
        this.adresa = adresa;
        this.telefon = telefon;
        this.naziv = naziv;
        this.tip = tip;
        this.jmbg = jmbg;
        this.pib = pib;
    }

    public Long getPoslovniPartnerID() {
        return poslovniPartnerID;
    }

    public void setPoslovniPartnerID(Long poslovniPartnerID) {
        this.poslovniPartnerID = poslovniPartnerID;
    }

    public String getŽiroRačun() {
        return žiroRačun;
    }

    public void setŽiroRačun(String žiroRačun) {
        this.žiroRačun = žiroRačun;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PoslovniPartner other = (PoslovniPartner) obj;
        if (!Objects.equals(this.poslovniPartnerID, other.poslovniPartnerID)) {
            return false;
        }
        return true;
    }

}

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
public class Proizvod {

    private Long proizvodID;
    private String klasifikacioniBroj;
    private String naziv;
    private Double cenaBezPDVa;
    private String mernaJedinica;
    private Integer stanje;
    private PDVStopa pdvStopa;

    public Proizvod() {
    }

    public Proizvod(Long proizvodID, String klasifikacioniBroj, String naziv, Double cenaBezPDVa, String mernaJedinica, Integer stanje, PDVStopa pdvStopa) {
        this.proizvodID = proizvodID;
        this.klasifikacioniBroj = klasifikacioniBroj;
        this.naziv = naziv;
        this.cenaBezPDVa = cenaBezPDVa;
        this.mernaJedinica = mernaJedinica;
        this.stanje = stanje;
        this.pdvStopa = pdvStopa;
    }

    public Long getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(Long proizvodID) {
        this.proizvodID = proizvodID;
    }

    public String getKlasifikacioniBroj() {
        return klasifikacioniBroj;
    }

    public void setKlasifikacioniBroj(String klasifikacioniBroj) {
        this.klasifikacioniBroj = klasifikacioniBroj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getCenaBezPDVa() {
        return cenaBezPDVa;
    }

    public void setCenaBezPDVa(Double cenaBezPDVa) {
        this.cenaBezPDVa = cenaBezPDVa;
    }

    public String getMernaJedinica() {
        return mernaJedinica;
    }

    public void setMernaJedinica(String mernaJedinica) {
        this.mernaJedinica = mernaJedinica;
    }

    public Integer getStanje() {
        return stanje;
    }

    public void setStanje(Integer stanje) {
        this.stanje = stanje;
    }

    public PDVStopa getPdvStopa() {
        return pdvStopa;
    }

    public void setPdvStopa(PDVStopa pdvStopa) {
        this.pdvStopa = pdvStopa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Proizvod other = (Proizvod) obj;
        if (!Objects.equals(this.proizvodID, other.proizvodID)) {
            return false;
        }
        return true;
    }
    
    

}

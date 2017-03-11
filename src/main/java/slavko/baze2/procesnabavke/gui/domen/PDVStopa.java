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
public class PDVStopa {
    private Long PDVStopaID;
    private String naziv;
    private Double procenat;

    public PDVStopa() {
    }

    public PDVStopa(Long PDVStopaID, String naziv, Double procenat) {
        this.PDVStopaID = PDVStopaID;
        this.naziv = naziv;
        this.procenat = procenat;
    }

    public Long getPDVStopaID() {
        return PDVStopaID;
    }

    public void setPDVStopaID(Long PDVStopaID) {
        this.PDVStopaID = PDVStopaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getProcenat() {
        return procenat;
    }

    public void setProcenat(Double procenat) {
        this.procenat = procenat;
    }

    @Override
    public String toString() {
        return naziv+"("+procenat+"%)";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.PDVStopaID);
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
        final PDVStopa other = (PDVStopa) obj;
        if (!Objects.equals(this.PDVStopaID, other.PDVStopaID)) {
            return false;
        }
        return true;
    }
    
    
    
    
}

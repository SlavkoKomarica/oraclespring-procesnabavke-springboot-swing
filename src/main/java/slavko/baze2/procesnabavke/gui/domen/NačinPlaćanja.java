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
public class NačinPlaćanja {
    private Long načinPlaćanjaID;
    private String naziv;

    public NačinPlaćanja() {
    }    

    public NačinPlaćanja(Long načinPlaćanjaID, String naziv) {
        this.načinPlaćanjaID = načinPlaćanjaID;
        this.naziv = naziv;
    }

    public Long getNačinPlaćanjaID() {
        return načinPlaćanjaID;
    }

    public void setNačinPlaćanjaID(Long načinPlaćanjaID) {
        this.načinPlaćanjaID = načinPlaćanjaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
}

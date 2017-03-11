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
public class StavkaFakture {
    private Integer redniBroj;
    private Integer količina;
    private Double jediničnaCena;
    private Double pdv;
    private Double prodajnaVrednost;
    private Proizvod proizvod;

    public StavkaFakture() {
        
    }

    public StavkaFakture(Integer redniBroj, Integer količina, Double jediničnaCena, Double pdv, Double prodajnaVrednost, Proizvod proizvod) {
        this.redniBroj = redniBroj;
        this.količina = količina;
        this.jediničnaCena = jediničnaCena;
        this.pdv = pdv;
        this.prodajnaVrednost = prodajnaVrednost;
        this.proizvod = proizvod;
    }

    public Integer getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(Integer redniBroj) {
        this.redniBroj = redniBroj;
    }

    public Integer getKoličina() {
        return količina;
    }

    public void setKoličina(Integer količina) {
        this.količina = količina;
    }

    public Double getJediničnaCena() {
        return jediničnaCena;
    }

    public void setJediničnaCena(Double jediničnaCena) {
        this.jediničnaCena = jediničnaCena;
    }

    public Double getPdv() {
        return pdv;
    }

    public void setPdv(Double pdv) {
        this.pdv = pdv;
    }

    public Double getProdajnaVrednost() {
        return prodajnaVrednost;
    }

    public void setProdajnaVrednost(Double prodajnaVrednost) {
        this.prodajnaVrednost = prodajnaVrednost;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

   
}

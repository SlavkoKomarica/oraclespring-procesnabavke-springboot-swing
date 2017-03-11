package slavko.baze2.procesnabavke.domain;

import lombok.ToString;
import slavko.baze2.procesnabavke.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Slavko Komarica
 */
@Entity
@Table(name = "zaposleni")
@ToString
public class Zaposleni extends BaseEntity {

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column(name = "jmbg", columnDefinition = "JMBG_TYPE")
    @org.hibernate.annotations.Type(type = "slavko.baze2.procesnabavke.domain.Jmbg")
    private Jmbg jmbg;

    public Zaposleni() {
    }

    public Zaposleni(Long sifra, String ime, String prezime, Jmbg jmbg) {
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
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

    public Jmbg getJmbg() {
        return jmbg;
    }

    public void setJmbg(Jmbg jmbg) {
        this.jmbg = jmbg;
    }

    @Override
    public String toString() {
        return "Zaposleni{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", jmbg=" + (jmbg == null ? "null" : jmbg.getJmbg()) +
                '}';
    }
}

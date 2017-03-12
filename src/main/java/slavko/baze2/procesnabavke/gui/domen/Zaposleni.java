package slavko.baze2.procesnabavke.gui.domen;

import lombok.ToString;
import org.hibernate.annotations.Type;
import slavko.baze2.procesnabavke.BaseEntity;
import slavko.baze2.procesnabavke.domain.Jmbg;

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

    @Column(name = "k_ime")
    private String korisnickoIme;

    @Column(name = "k_sifra")
    private String korisnickaSifra;

    @Column
    private String prezime;

    @Column(name = "jmbg", columnDefinition = "JMBG_TYPE")
    @Type(type = "slavko.baze2.procesnabavke.domain.Jmbg")
    private Jmbg jmbg;

    public Zaposleni() {
    }

    private Zaposleni(Builder builder) {
        setSifra(builder.sifra);
        setIme(builder.ime);
        setKorisnickoIme(builder.korisnickoIme);
        setKorisnickaSifra(builder.korisnickaSifra);
        setPrezime(builder.prezime);
        setJmbg(builder.jmbg);
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getKorisnickaSifra() {
        return korisnickaSifra;
    }

    public void setKorisnickaSifra(String korisnickaSifra) {
        this.korisnickaSifra = korisnickaSifra;
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

    public String printInfo() {
        return ime + " " + prezime;
    }


    public static final class Builder {
        private Long sifra;
        private String ime;
        private String korisnickoIme;
        private String korisnickaSifra;
        private String prezime;
        private Jmbg jmbg;

        public Builder() {
        }

        public Builder withSifra(Long val) {
            sifra = val;
            return this;
        }

        public Builder withIme(String val) {
            ime = val;
            return this;
        }

        public Builder withKorisnickoIme(String val) {
            korisnickoIme = val;
            return this;
        }

        public Builder withKorisnickaSifra(String val) {
            korisnickaSifra = val;
            return this;
        }

        public Builder withPrezime(String val) {
            prezime = val;
            return this;
        }

        public Builder withJmbg(Jmbg val) {
            jmbg = val;
            return this;
        }

        public Zaposleni build() {
            return new Zaposleni(this);
        }
    }
}

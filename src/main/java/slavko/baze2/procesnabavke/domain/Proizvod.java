package slavko.baze2.procesnabavke.domain;

import lombok.ToString;
import slavko.baze2.procesnabavke.BaseEntity;

import javax.persistence.*;

/**
 * @author Slavko Komarica
 */
@Entity
@Table(name = "proizvod")
@ToString
public class Proizvod extends BaseEntity {

    @Column
    private String naziv;

    @Column(name = "akt_cena")
    private Double aktCena;

    @Column
    private String opis;

    @Column(name = "sifra_tipa_proizvoda")
    private Long sifraTipaProizvoda;

    @ManyToOne
    @JoinColumn(name = "sifra_tipa_proizvoda", insertable = false, updatable = false)
    private TipProizvoda tipProizvoda;

    @Column(name = "sifra_jedinice_mere")
    private Long sifraJediniceMere;

    @ManyToOne
    @JoinColumn(name = "sifra_jedinice_mere", insertable = false, updatable = false)
    private JedinicaMere jedinicaMere;


    public Proizvod() {
    }

    private Proizvod(Builder builder) {
        setSifra(builder.sifra);
        setNaziv(builder.naziv);
        setAktCena(builder.aktCena);
        setOpis(builder.opis);
        setSifraTipaProizvoda(builder.sifraTipaProizvoda);
        setTipProizvoda(builder.tipProizvoda);
        setSifraJediniceMere(builder.sifraJediniceMere);
        setJedinicaMere(builder.jedinicaMere);
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getAktCena() {
        return aktCena;
    }

    public void setAktCena(Double aktCena) {
        this.aktCena = aktCena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Long getSifraTipaProizvoda() {
        return sifraTipaProizvoda;
    }

    public void setSifraTipaProizvoda(Long sifraTipaProizvoda) {
        this.sifraTipaProizvoda = sifraTipaProizvoda;
    }

    public TipProizvoda getTipProizvoda() {
        return tipProizvoda;
    }

    public void setTipProizvoda(TipProizvoda tipProizvoda) {
        this.tipProizvoda = tipProizvoda;
    }

    public Long getSifraJediniceMere() {
        return sifraJediniceMere;
    }

    public void setSifraJediniceMere(Long sifraJediniceMere) {
        this.sifraJediniceMere = sifraJediniceMere;
    }

    public JedinicaMere getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(JedinicaMere jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }


    public static final class Builder {
        private Long sifra;
        private String naziv;
        private Double aktCena;
        private String opis;
        private Long sifraTipaProizvoda;
        private TipProizvoda tipProizvoda;
        private Long sifraJediniceMere;
        private JedinicaMere jedinicaMere;

        public Builder() {
        }

        public Builder withSifra(Long val) {
            sifra = val;
            return this;
        }

        public Builder withNaziv(String val) {
            naziv = val;
            return this;
        }

        public Builder withAktCena(Double val) {
            aktCena = val;
            return this;
        }

        public Builder withOpis(String val) {
            opis = val;
            return this;
        }

        public Builder withSifraTipaProizvoda(Long val) {
            sifraTipaProizvoda = val;
            return this;
        }

        public Builder withTipProizvoda(TipProizvoda val) {
            tipProizvoda = val;
            return this;
        }

        public Builder withSifraJediniceMere(Long val) {
            sifraJediniceMere = val;
            return this;
        }

        public Builder withJedinicaMere(JedinicaMere val) {
            jedinicaMere = val;
            return this;
        }

        public Proizvod build() {
            return new Proizvod(this);
        }
    }
}

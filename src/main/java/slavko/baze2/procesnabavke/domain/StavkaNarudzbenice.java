package slavko.baze2.procesnabavke.domain;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Slavko Komarica
 */
@Embeddable
@ToString
public class StavkaNarudzbenice {

    @Column(name = "broj_stavke", nullable = false)
    private Long brStavke;

    private Integer kolicina;

    @Column(name = "sifra_proizvoda")
    private Long sifraProizvoda;

    public StavkaNarudzbenice() {
    }

    private StavkaNarudzbenice(Builder builder) {
        setBrStavke(builder.brStavke);
        setKolicina(builder.kolicina);
        setSifraProizvoda(builder.sifraProizvoda);
    }

    public Long getBrStavke() {
        return brStavke;
    }

    public void setBrStavke(Long brStavke) {
        this.brStavke = brStavke;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public Long getSifraProizvoda() {
        return sifraProizvoda;
    }

    public void setSifraProizvoda(Long sifraProizvoda) {
        this.sifraProizvoda = sifraProizvoda;
    }

    public static final class Builder {
        private Long brStavke;
        private Integer kolicina;
        private Long sifraProizvoda;

        public Builder() {
        }

        public Builder withBrStavke(Long val) {
            brStavke = val;
            return this;
        }

        public Builder withKolicina(Integer val) {
            kolicina = val;
            return this;
        }

        public Builder withSifraProizvoda(Long val) {
            sifraProizvoda = val;
            return this;
        }

        public StavkaNarudzbenice build() {
            return new StavkaNarudzbenice(this);
        }
    }
}

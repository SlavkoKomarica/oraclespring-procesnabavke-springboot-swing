package slavko.baze2.procesnabavke.domain;

import lombok.ToString;

import javax.persistence.*;

/**
 * @author Slavko Komarica
 */
@Entity
@Table(name = "zaposleni_detalji")
@ToString
public class ZaposleniDetalji {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sifra_zaposlenog")
    private Long sifraZaposlenog;

    @Column
    private String pozicija;

    @Column(name = "sifra_opstine")
    private Long sifraOpstine;

    @ManyToOne
    @JoinColumn(name = "sifra_opstine", insertable = false, updatable = false)
    private Opstina opstina;

    @Column(name = "sifra_zaposlenog_nadr")
    private Long sifraNadredjenog;

    @ManyToOne
    @JoinColumn(name = "sifra_zaposlenog_nadr", insertable = false, updatable = false)
    private Zaposleni nadredjeni;

    public ZaposleniDetalji() {
    }

    private ZaposleniDetalji(Builder builder) {
        sifraZaposlenog = builder.sifraZaposlenog;
        setPozicija(builder.pozicija);
        setSifraOpstine(builder.sifraOpstine);
        setOpstina(builder.opstina);
        setSifraNadredjenog(builder.sifraNadredjenog);
        setNadredjeni(builder.nadredjeni);
    }


    public Long getSifraNadredjenog() {
        return sifraNadredjenog;
    }

    public void setSifraNadredjenog(Long sifraNadredjenog) {
        this.sifraNadredjenog = sifraNadredjenog;
    }

    public Zaposleni getNadredjeni() {
        return nadredjeni;
    }

    public void setNadredjeni(Zaposleni nadredjeni) {
        this.nadredjeni = nadredjeni;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public Long getSifraOpstine() {
        return sifraOpstine;
    }

    public void setSifraOpstine(Long sifraOpstine) {
        this.sifraOpstine = sifraOpstine;
    }

    public Opstina getOpstina() {
        return opstina;
    }

    public void setOpstina(Opstina opstina) {
        this.opstina = opstina;
    }


    public static final class Builder {
        private Long sifraZaposlenog;
        private String pozicija;
        private Long sifraOpstine;
        private Opstina opstina;
        private Long sifraNadredjenog;
        private Zaposleni nadredjeni;

        public Builder() {
        }

        public Builder withSifraZaposlenog(Long val) {
            sifraZaposlenog = val;
            return this;
        }

        public Builder withPozicija(String val) {
            pozicija = val;
            return this;
        }

        public Builder withSifraOpstine(Long val) {
            sifraOpstine = val;
            return this;
        }

        public Builder withOpstina(Opstina val) {
            opstina = val;
            return this;
        }

        public Builder withSifraNadredjenog(Long val) {
            sifraNadredjenog = val;
            return this;
        }

        public Builder withNadredjeni(Zaposleni val) {
            nadredjeni = val;
            return this;
        }

        public ZaposleniDetalji build() {
            return new ZaposleniDetalji(this);
        }
    }
}

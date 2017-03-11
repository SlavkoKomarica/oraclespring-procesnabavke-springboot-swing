package slavko.baze2.procesnabavke.domain;

import lombok.ToString;
import slavko.baze2.procesnabavke.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Slavko Komarica
 */
@Entity
@Table(name = "ugovor_o_nabavci")
@ToString
public class Ugovor extends BaseEntity {

    @Column
    private Date datum;

    @Column(name = "opsti_uslovi")
    private String opstiUslovi;

    @Column(name = "sifra_zaposlenog")
    private Long sifraZaposlenog;

    @ManyToOne
    @JoinColumn(name = "sifra_zaposlenog", insertable = false, updatable = false)
    private Zaposleni zaposleni;

    @Column(name = "sifra_ponude")
    private Long sifraPonude;

    @ManyToOne
    @JoinColumn(name = "sifra_ponude", insertable = false, updatable = false)
    private Ponuda ponuda;

    public Ugovor() {
    }

    private Ugovor(Builder builder) {
        setSifra(builder.sifra);
        setDatum(builder.datum);
        setOpstiUslovi(builder.opstiUslovi);
        setSifraZaposlenog(builder.sifraZaposlenog);
        setZaposleni(builder.zaposleni);
        setSifraPonude(builder.sifraPonude);
        setPonuda(builder.ponuda);
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getOpstiUslovi() {
        return opstiUslovi;
    }

    public void setOpstiUslovi(String opstiUslovi) {
        this.opstiUslovi = opstiUslovi;
    }

    public Long getSifraZaposlenog() {
        return sifraZaposlenog;
    }

    public void setSifraZaposlenog(Long sifraZaposlenog) {
        this.sifraZaposlenog = sifraZaposlenog;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Long getSifraPonude() {
        return sifraPonude;
    }

    public void setSifraPonude(Long sifraPonude) {
        this.sifraPonude = sifraPonude;
    }

    public Ponuda getPonuda() {
        return ponuda;
    }

    public void setPonuda(Ponuda ponuda) {
        this.ponuda = ponuda;
    }


    public static final class Builder {
        private Long sifra;
        private Date datum;
        private String opstiUslovi;
        private Long sifraZaposlenog;
        private Zaposleni zaposleni;
        private Long sifraPonude;
        private Ponuda ponuda;

        public Builder() {
        }

        public Builder withSifra(Long val) {
            sifra = val;
            return this;
        }

        public Builder withDatum(Date val) {
            datum = val;
            return this;
        }

        public Builder withOpstiUslovi(String val) {
            opstiUslovi = val;
            return this;
        }

        public Builder withSifraZaposlenog(Long val) {
            sifraZaposlenog = val;
            return this;
        }

        public Builder withZaposleni(Zaposleni val) {
            zaposleni = val;
            return this;
        }

        public Builder withSifraPonude(Long val) {
            sifraPonude = val;
            return this;
        }

        public Builder withPonuda(Ponuda val) {
            ponuda = val;
            return this;
        }

        public Ugovor build() {
            return new Ugovor(this);
        }
    }
}

package slavko.baze2.procesnabavke.domain;

import lombok.ToString;
import slavko.baze2.procesnabavke.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Slavko Komarica
 */
@Entity
@Table(name = "narudzbenica")
@ToString
public class Narudzbenica extends BaseEntity {

    @Column(name = "datum_kreiranja")
    private Date datumKreiranja;

    @Column(name = "datum_narucivanja")
    private Date datumNarucivanja;

    @Column
    private Double ukupno;

    @Column(name = "sifra_zap_obr")
    private Long sifraObracunao;

    @ManyToOne
    @JoinColumn(name = "sifra_zap_obr", insertable = false, updatable = false)
    private Zaposleni obracunao;

    @Column(name = "sifra_zap_odob")
    private Long sifraOdobrio;

    @ManyToOne
    @JoinColumn(name = "sifra_zap_odob", insertable = false, updatable = false)
    private Zaposleni odobrio;

    @Column(name = "sifra_ugovora")
    private Long sifraUgovora;

    @ManyToOne
    @JoinColumn(name = "sifra_ugovora", insertable = false, updatable = false)
    private Ugovor ugovor;

    @ElementCollection
    @CollectionTable(name = "stavke_narudzbenice", joinColumns = @JoinColumn(name = "sifra_narudzbenice", referencedColumnName = "sifra"))
    private Set<StavkaNarudzbenice> stavke = new HashSet<>();

    public Narudzbenica() {
    }

    private Narudzbenica(Builder builder) {
        setSifra(builder.sifra);
        setDatumKreiranja(builder.datumKreiranja);
        setDatumNarucivanja(builder.datumNarucivanja);
        setUkupno(builder.ukupno);
        setSifraObracunao(builder.sifraObracunao);
        setObracunao(builder.obracunao);
        setSifraOdobrio(builder.sifraOdobrio);
        setOdobrio(builder.odobrio);
        setSifraUgovora(builder.sifraUgovora);
        setUgovor(builder.ugovor);
        setStavke(builder.stavke);
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Date getDatumNarucivanja() {
        return datumNarucivanja;
    }

    public void setDatumNarucivanja(Date datumNarucivanja) {
        this.datumNarucivanja = datumNarucivanja;
    }

    public Double getUkupno() {
        return ukupno;
    }

    public void setUkupno(Double ukupno) {
        this.ukupno = ukupno;
    }

    public Long getSifraObracunao() {
        return sifraObracunao;
    }

    public void setSifraObracunao(Long sifraObracunao) {
        this.sifraObracunao = sifraObracunao;
    }

    public Zaposleni getObracunao() {
        return obracunao;
    }

    public void setObracunao(Zaposleni obracunao) {
        this.obracunao = obracunao;
    }

    public Long getSifraOdobrio() {
        return sifraOdobrio;
    }

    public void setSifraOdobrio(Long sifraOdobrio) {
        this.sifraOdobrio = sifraOdobrio;
    }

    public Zaposleni getOdobrio() {
        return odobrio;
    }

    public void setOdobrio(Zaposleni odobrio) {
        this.odobrio = odobrio;
    }

    public Long getSifraUgovora() {
        return sifraUgovora;
    }

    public void setSifraUgovora(Long sifraUgovora) {
        this.sifraUgovora = sifraUgovora;
    }

    public Ugovor getUgovor() {
        return ugovor;
    }

    public void setUgovor(Ugovor ugovor) {
        this.ugovor = ugovor;
    }

    public Set<StavkaNarudzbenice> getStavke() {
        return stavke;
    }

    public void setStavke(Set<StavkaNarudzbenice> stavke) {
        this.stavke = stavke;
    }


    public static final class Builder {
        private Long sifra;
        private Date datumKreiranja;
        private Date datumNarucivanja;
        private Double ukupno;
        private Long sifraObracunao;
        private Zaposleni obracunao;
        private Long sifraOdobrio;
        private Zaposleni odobrio;
        private Long sifraUgovora;
        private Ugovor ugovor;
        private Set<StavkaNarudzbenice> stavke;

        public Builder() {
        }

        public Builder withSifra(Long val) {
            sifra = val;
            return this;
        }

        public Builder withDatumKreiranja(Date val) {
            datumKreiranja = val;
            return this;
        }

        public Builder withDatumNarucivanja(Date val) {
            datumNarucivanja = val;
            return this;
        }

        public Builder withUkupno(Double val) {
            ukupno = val;
            return this;
        }

        public Builder withSifraObracunao(Long val) {
            sifraObracunao = val;
            return this;
        }

        public Builder withObracunao(Zaposleni val) {
            obracunao = val;
            return this;
        }

        public Builder withSifraOdobrio(Long val) {
            sifraOdobrio = val;
            return this;
        }

        public Builder withOdobrio(Zaposleni val) {
            odobrio = val;
            return this;
        }

        public Builder withSifraUgovora(Long val) {
            sifraUgovora = val;
            return this;
        }

        public Builder withUgovor(Ugovor val) {
            ugovor = val;
            return this;
        }

        public Builder withStavke(Set<StavkaNarudzbenice> val) {
            stavke = val;
            return this;
        }

        public Narudzbenica build() {
            return new Narudzbenica(this);
        }
    }
}

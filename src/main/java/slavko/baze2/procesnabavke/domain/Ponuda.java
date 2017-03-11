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
@Table(name = "ponuda")
@ToString
public class Ponuda extends BaseEntity {

    @Column(name = "datum_ponude")
    private Date datumPonude;

    @Column(name = "rok_placanja")
    private Date rokPlacanja;

    @Column(name = "napomena")
    private String napomena;

    @Column(name = "sifra_valute")
    private Long sifraValute;

    @ManyToOne
    @JoinColumn(name = "sifra_valute", insertable = false, updatable = false)
    private Valuta valuta;

    @Column(name = "naziv_valute")
    private String nazivValute;

    @Column(name = "sifra_dobavljaca")
    private Long sifraDobavljaca;

    @ManyToOne
    @JoinColumn(name = "sifra_dobavljaca", insertable = false, updatable = false)
    private Dobavljac dobavljac;

    @Column(name = "sifra_zap_primio")
    private Long sifraPrimio;

    @ManyToOne
    @JoinColumn(name = "sifra_zap_primio", insertable = false, updatable = false)
    private Zaposleni primio;

    @ElementCollection
    @CollectionTable(name = "stavke_ponude", joinColumns = @JoinColumn(name = "sifra_ponude", referencedColumnName = "sifra"))
    private Set<StavkaPonude> stavke = new HashSet<>();

    public Ponuda() {
    }

    private Ponuda(Builder builder) {
        setSifra(builder.sifra);
        setDatumPonude(builder.datumPonude);
        setRokPlacanja(builder.rokPlacanja);
        setNapomena(builder.napomena);
        setSifraValute(builder.sifraValute);
        setValuta(builder.valuta);
        setNazivValute(builder.nazivValute);
        setSifraDobavljaca(builder.sifraDobavljaca);
        setDobavljac(builder.dobavljac);
        setSifraPrimio(builder.sifraPrimio);
        setPrimio(builder.primio);
        setStavke(builder.stavke);
    }

    public Date getDatumPonude() {
        return datumPonude;
    }

    public void setDatumPonude(Date datumPonude) {
        this.datumPonude = datumPonude;
    }

    public Date getRokPlacanja() {
        return rokPlacanja;
    }

    public void setRokPlacanja(Date rokPlacanja) {
        this.rokPlacanja = rokPlacanja;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Long getSifraValute() {
        return sifraValute;
    }

    public void setSifraValute(Long sifraValute) {
        this.sifraValute = sifraValute;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }

    public String getNazivValute() {
        return nazivValute;
    }

    public void setNazivValute(String nazivValute) {
        this.nazivValute = nazivValute;
    }

    public Long getSifraDobavljaca() {
        return sifraDobavljaca;
    }

    public void setSifraDobavljaca(Long sifraDobavljaca) {
        this.sifraDobavljaca = sifraDobavljaca;
    }

    public Dobavljac getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(Dobavljac dobavljac) {
        this.dobavljac = dobavljac;
    }

    public Long getSifraPrimio() {
        return sifraPrimio;
    }

    public void setSifraPrimio(Long sifraPrimio) {
        this.sifraPrimio = sifraPrimio;
    }

    public Zaposleni getPrimio() {
        return primio;
    }

    public void setPrimio(Zaposleni primio) {
        this.primio = primio;
    }

    public Set<StavkaPonude> getStavke() {
        return stavke;
    }

    public void setStavke(Set<StavkaPonude> stavke) {
        this.stavke = stavke;
    }

    public static final class Builder {
        private Long sifra;
        private Date datumPonude;
        private Date rokPlacanja;
        private String napomena;
        private Long sifraValute;
        private Valuta valuta;
        private String nazivValute;
        private Long sifraDobavljaca;
        private Dobavljac dobavljac;
        private Long sifraPrimio;
        private Zaposleni primio;
        private Set<StavkaPonude> stavke;

        public Builder() {
        }

        public Builder withSifra(Long val) {
            sifra = val;
            return this;
        }

        public Builder withDatumPonude(Date val) {
            datumPonude = val;
            return this;
        }

        public Builder withRokPlacanja(Date val) {
            rokPlacanja = val;
            return this;
        }

        public Builder withNapomena(String val) {
            napomena = val;
            return this;
        }

        public Builder withSifraValute(Long val) {
            sifraValute = val;
            return this;
        }

        public Builder withValuta(Valuta val) {
            valuta = val;
            return this;
        }

        public Builder withNazivValute(String val) {
            nazivValute = val;
            return this;
        }

        public Builder withSifraDobavljaca(Long val) {
            sifraDobavljaca = val;
            return this;
        }

        public Builder withDobavljac(Dobavljac val) {
            dobavljac = val;
            return this;
        }

        public Builder withSifraPrimio(Long val) {
            sifraPrimio = val;
            return this;
        }

        public Builder withPrimio(Zaposleni val) {
            primio = val;
            return this;
        }

        public Builder withStavke(Set<StavkaPonude> val) {
            stavke = val;
            return this;
        }

        public Ponuda build() {
            return new Ponuda(this);
        }
    }
}

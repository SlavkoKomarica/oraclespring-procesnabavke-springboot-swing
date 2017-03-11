package slavko.baze2.procesnabavke.domain;

import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Slavko Komarica
 */
@Entity
@Table(name = "otpremnica")
@IdClass(OtpremnicaId.class)
@ToString
public class Otpremnica {

    @Id
    @Column(name = "sifra_dobavljaca")
    private Long sifraDobavljaca;

    @ManyToOne
    @JoinColumn(name = "sifra_dobavljaca", insertable = false, updatable = false)
    private Dobavljac dobavljac;

    @Column(name = "naziv_dobavljaca")
    private String nazivDobavljaca;

    @Id
    @Column(name = "broj_otpremnice")
    private Long brojOtpremnice;

    @Column(name = "datum_prijema")
    private Date datumPrijema;

    @Column(name = "sifra_zaposlenog")
    private Long sifraZaposlenog;

    @ManyToOne
    @JoinColumn(name = "sifra_zaposlenog", insertable = false, updatable = false)
    private Zaposleni zaposleni;

    @Column(name = "sifra_narudzbenice")
    private Long sifraNarudzbenice;

    @ManyToOne
    @JoinColumn(name = "sifra_narudzbenice", insertable = false, updatable = false)
    private Narudzbenica narudzbenica;

    @Column(name = "sifra_nacina_otpreme")
    private Long sifraNacinaOtpreme;

    @ManyToOne
    @JoinColumn(name = "sifra_nacina_otpreme", insertable = false, updatable = false)
    private NacinOtpreme nacinOtpreme;

    @ElementCollection
    @CollectionTable(name = "stavke_otpremnice", joinColumns = {
            @JoinColumn(name = "sifra_dobavljaca", referencedColumnName = "sifra_dobavljaca"),
            @JoinColumn(name = "broj_otpremnice", referencedColumnName = "broj_otpremnice")})
    private Set<StavkaOtpremnice> stavke = new HashSet<>();

    public Otpremnica() {
    }

    private Otpremnica(Builder builder) {
        setSifraDobavljaca(builder.sifraDobavljaca);
        setDobavljac(builder.dobavljac);
        setNazivDobavljaca(builder.nazivDobavljaca);
        setBrojOtpremnice(builder.brojOtpremnice);
        setDatumPrijema(builder.datumPrijema);
        setSifraZaposlenog(builder.sifraZaposlenog);
        setZaposleni(builder.zaposleni);
        setSifraNarudzbenice(builder.sifraNarudzbenice);
        setNarudzbenica(builder.narudzbenica);
        setSifraNacinaOtpreme(builder.sifraNacinaOtpreme);
        setNacinOtpreme(builder.nacinOtpreme);
        setStavke(builder.stavke);
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

    public String getNazivDobavljaca() {
        return nazivDobavljaca;
    }

    public void setNazivDobavljaca(String nazivDobavljaca) {
        this.nazivDobavljaca = nazivDobavljaca;
    }

    public Long getBrojOtpremnice() {
        return brojOtpremnice;
    }

    public void setBrojOtpremnice(Long brojOtpremnice) {
        this.brojOtpremnice = brojOtpremnice;
    }

    public Date getDatumPrijema() {
        return datumPrijema;
    }

    public void setDatumPrijema(Date datumPrijema) {
        this.datumPrijema = datumPrijema;
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

    public Long getSifraNarudzbenice() {
        return sifraNarudzbenice;
    }

    public void setSifraNarudzbenice(Long sifraNarudzbenice) {
        this.sifraNarudzbenice = sifraNarudzbenice;
    }

    public Narudzbenica getNarudzbenica() {
        return narudzbenica;
    }

    public void setNarudzbenica(Narudzbenica narudzbenica) {
        this.narudzbenica = narudzbenica;
    }

    public Long getSifraNacinaOtpreme() {
        return sifraNacinaOtpreme;
    }

    public void setSifraNacinaOtpreme(Long sifraNacinaOtpreme) {
        this.sifraNacinaOtpreme = sifraNacinaOtpreme;
    }

    public NacinOtpreme getNacinOtpreme() {
        return nacinOtpreme;
    }

    public void setNacinOtpreme(NacinOtpreme nacinOtpreme) {
        this.nacinOtpreme = nacinOtpreme;
    }

    public Set<StavkaOtpremnice> getStavke() {
        return stavke;
    }

    public void setStavke(Set<StavkaOtpremnice> stavke) {
        this.stavke = stavke;
    }

    public static final class Builder {
        private Long sifraDobavljaca;
        private Dobavljac dobavljac;
        private String nazivDobavljaca;
        private Long brojOtpremnice;
        private Date datumPrijema;
        private Long sifraZaposlenog;
        private Zaposleni zaposleni;
        private Long sifraNarudzbenice;
        private Narudzbenica narudzbenica;
        private Long sifraNacinaOtpreme;
        private NacinOtpreme nacinOtpreme;
        private Set<StavkaOtpremnice> stavke;

        public Builder() {
        }

        public Builder withSifraDobavljaca(Long val) {
            sifraDobavljaca = val;
            return this;
        }

        public Builder withDobavljac(Dobavljac val) {
            dobavljac = val;
            return this;
        }

        public Builder withNazivDobavljaca(String val) {
            nazivDobavljaca = val;
            return this;
        }

        public Builder withBrojOtpremnice(Long val) {
            brojOtpremnice = val;
            return this;
        }

        public Builder withDatumPrijema(Date val) {
            datumPrijema = val;
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

        public Builder withSifraNarudzbenice(Long val) {
            sifraNarudzbenice = val;
            return this;
        }

        public Builder withNarudzbenica(Narudzbenica val) {
            narudzbenica = val;
            return this;
        }

        public Builder withSifraNacinaOtpreme(Long val) {
            sifraNacinaOtpreme = val;
            return this;
        }

        public Builder withNacinOtpreme(NacinOtpreme val) {
            nacinOtpreme = val;
            return this;
        }

        public Builder withStavke(Set<StavkaOtpremnice> val) {
            stavke = val;
            return this;
        }

        public Otpremnica build() {
            return new Otpremnica(this);
        }
    }
}

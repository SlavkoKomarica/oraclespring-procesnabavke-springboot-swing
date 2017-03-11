package slavko.baze2.procesnabavke.domain;

import lombok.ToString;
import slavko.baze2.procesnabavke.BaseEntity;

import javax.persistence.*;

/**
 * @author Slavko Komarica
 */
@Entity
@Table(name = "dobavljac")
@ToString
public class Dobavljac extends BaseEntity {

    @Column
    private String naziv;

    @Column
    private String pib;

    @Column
    private String swift;

    @Column
    private String iban;

    @Column(name = "sifra_opstine")
    private Long sifraOpstine;

    @ManyToOne
    @JoinColumn(name = "sifra_opstine", insertable = false, updatable = false)
    private Opstina opstina;

    public Dobavljac() {
    }

    private Dobavljac(Builder builder) {
        setNaziv(builder.naziv);
        setSifra(builder.sifra);
        setPib(builder.pib);
        setSwift(builder.swift);
        setIban(builder.iban);
        setSifraOpstine(builder.sifraOpstine);
        setOpstina(builder.opstina);
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
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
        private String naziv;
        private Long sifra;
        private String pib;
        private String swift;
        private String iban;
        private Long sifraOpstine;
        private Opstina opstina;

        public Builder() {
        }

        public Builder withNaziv(String val) {
            naziv = val;
            return this;
        }

        public Builder withSifra(Long val) {
            sifra = val;
            return this;
        }

        public Builder withPib(String val) {
            pib = val;
            return this;
        }

        public Builder withSwift(String val) {
            swift = val;
            return this;
        }

        public Builder withIban(String val) {
            iban = val;
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

        public Dobavljac build() {
            return new Dobavljac(this);
        }
    }

    @Override
    public String toString() {
        return "Dobavljac{" +
                "naziv='" + naziv + '\'' +
                ", pib='" + pib + '\'' +
                ", swift='" + swift + '\'' +
                ", iban='" + iban + '\'' +
                ", sifraOpstine=" + sifraOpstine +
                ", opstina=" + opstina +
                '}';
    }
}

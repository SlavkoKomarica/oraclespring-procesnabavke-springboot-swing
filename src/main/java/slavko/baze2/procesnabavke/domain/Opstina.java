package slavko.baze2.procesnabavke.domain;

import lombok.ToString;
import slavko.baze2.procesnabavke.BaseEntity;

import javax.persistence.*;

/**
 * @author Slavko Komarica
 */
@Entity
@Table(name = "opstina")
@ToString
public class Opstina extends BaseEntity {

    @Column
    private String naziv;

    @Column(name = "sifra_grada")
    private Long sifraGrada;

    @ManyToOne
    @JoinColumn(name = "sifra_grada", insertable = false, updatable = false)
    private Grad grad;

    public Opstina() {
    }

    public Opstina(Long sifra, String naziv, Long sifraGrada, Grad grad) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.sifraGrada = sifraGrada;
        this.grad = grad;
    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Long getSifraGrada() {
        return sifraGrada;
    }

    public void setSifraGrada(Long sifraGrada) {
        this.sifraGrada = sifraGrada;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public String toString() {
        return "Opstina{" +
                "naziv='" + naziv + '\'' +
                ", sifraGrada=" + sifraGrada +
                ", grad=" + grad +
                '}';
    }
}

package slavko.baze2.procesnabavke.domain;

import lombok.ToString;
import slavko.baze2.procesnabavke.BaseEntity;

import javax.persistence.*;

/**
 * @author Slavko Komarica
 */
@Entity
@Table(name = "grad")
@ToString
public class Grad extends BaseEntity {

    @Column
    private String naziv;

    @Column(name = "sifra_drzave")
    private Long sifraDrzave;

    @ManyToOne
    @JoinColumn(name = "sifra_drzave", insertable = false, updatable = false)
    private Drzava drzava;

    public Grad() {
    }

    public Grad(Long sifra, String naziv, Long sifraDrzave, Drzava drzava) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.sifraDrzave = sifraDrzave;
        this.drzava = drzava;
    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Long getSifraDrzave() {
        return sifraDrzave;
    }

    public void setSifraDrzave(Long sifraDrzave) {
        this.sifraDrzave = sifraDrzave;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }

    @Override
    public String toString() {
        return "Grad{" +
                "naziv='" + naziv + '\'' +
                ", sifraDrzave=" + sifraDrzave +
                ", drzava=" + drzava +
                '}';
    }
}

package slavko.baze2.procesnabavke.domain;

import lombok.ToString;
import slavko.baze2.procesnabavke.BaseEntity;

import javax.persistence.*;

/**
 * @author Slavko Komarica
 */
@Entity
@Table(name = "drzava")
@ToString
public class Drzava extends BaseEntity {

    @Column
    private String naziv;

    public Drzava() {
    }

    public Drzava(Long sifra, String naziv) {
        this.sifra = sifra;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}

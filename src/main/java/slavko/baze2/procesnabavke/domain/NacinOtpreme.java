package slavko.baze2.procesnabavke.domain;

import lombok.ToString;
import slavko.baze2.procesnabavke.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Slavko Komarica
 */
@Entity
@Table(name = "nacin_otpreme")
@ToString
public class NacinOtpreme extends BaseEntity {
    @Column
    private String naziv;

    public NacinOtpreme() {
    }

    public NacinOtpreme(Long sifra, String naziv) {
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

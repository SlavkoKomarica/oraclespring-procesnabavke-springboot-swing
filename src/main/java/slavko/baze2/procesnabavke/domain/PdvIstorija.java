package slavko.baze2.procesnabavke.domain;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

/**
 * @author Slavko Komarica
 */
@Embeddable
@ToString
public class PdvIstorija {

    @Column(nullable = false)
    private Date datum;

    @Column
    private Double stopa;

    public PdvIstorija() {
    }

    public PdvIstorija(Date datum, Double stopa) {
        this.datum = datum;
        this.stopa = stopa;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Double getStopa() {
        return stopa;
    }

    public void setStopa(Double stopa) {
        this.stopa = stopa;
    }
}

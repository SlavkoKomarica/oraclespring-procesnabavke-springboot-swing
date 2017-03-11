package slavko.baze2.procesnabavke;

import javax.persistence.*;

/**
 * @author Slavko Komarica
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name = "sifra")
    protected Long sifra;

    public Long getSifra() {
        return sifra;
    }

    public void setSifra(Long sifra) {
        this.sifra = sifra;
    }

}

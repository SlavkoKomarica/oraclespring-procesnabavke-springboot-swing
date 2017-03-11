package slavko.baze2.procesnabavke.domain;

import lombok.ToString;
import slavko.baze2.procesnabavke.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Slavko Komarica
 */
@Entity
@Table(name = "tipproizvoda")
@ToString
public class TipProizvoda extends BaseEntity {

    @Column
    private String naziv;

    @ElementCollection
    @CollectionTable(name = "pdv_istorija", joinColumns = @JoinColumn(name = "sifra_tipa_proizvoda", referencedColumnName = "sifra"))
    private Set<PdvIstorija> pdvIstorija = new HashSet<>();

    public TipProizvoda() {
    }

    public TipProizvoda(Long sifra, String naziv, Set<PdvIstorija> pdvIstorija) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.pdvIstorija = pdvIstorija;
    }
}

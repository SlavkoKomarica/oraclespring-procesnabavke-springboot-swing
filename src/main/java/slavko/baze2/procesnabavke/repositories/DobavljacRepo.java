package slavko.baze2.procesnabavke.repositories;

import org.springframework.data.jpa.repository.Query;
import slavko.baze2.procesnabavke.BaseRepository;
import slavko.baze2.procesnabavke.domain.Dobavljac;

import java.util.List;

/**
 * @author Slavko Komarica
 */
public interface DobavljacRepo extends BaseRepository<Dobavljac, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM dobavljac partition(dobavljac_domaci)")
    List<Dobavljac> findRS();

    @Query(nativeQuery = true, value = "SELECT * FROM dobavljac partition(dobavljac_strani)")
    List<Dobavljac> findForeign();

    @Query(nativeQuery = true, value = "SELECT * FROM dobavljac partition(dobavljac_nk)")
    List<Dobavljac> findUnclassified();


}

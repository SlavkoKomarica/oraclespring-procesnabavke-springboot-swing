package slavko.baze2.procesnabavke;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Slavko Komarica
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

    @Override
    List<T> findAll();

}

package slavko.baze2.procesnabavke;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author Slavko Komarica
 */
public abstract class BaseService<T, ID extends Serializable> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    protected final BaseRepository<T, ID> repository;

    protected final Class<T> entityType;

    protected BaseService(BaseRepository<T, ID> repository) {
        this.repository = repository;
        this.entityType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Transactional(readOnly = true)
    public List<T> getAll() {
        logger.debug("Getting all {}", entityType.getSimpleName());

        List<T> result = repository.findAll();

        logger.debug("All {} found: {}", entityType.getSimpleName(), result);

        return result;
    }

    @Transactional(readOnly = true)
    public T get(ID id) {
        logger.debug("Getting {} with id {}", entityType.getSimpleName(), id);

        T result = repository.findOne(id);

        logger.debug("{} with id {} found: {}", entityType.getSimpleName(), id, result);

        return result;
    }

    @Transactional
    public T create(T t) {
        logger.debug("Creating {} from {}", entityType.getSimpleName(), t);

        t = repository.save(t);

        logger.debug("{} created: {}", entityType.getSimpleName(), t);

        return t;
    }

    @Transactional
    public T update(ID id, T t) {
        logger.debug("Updating {} with id: {} from {}", entityType.getSimpleName(), id, t);

        if (!repository.exists(id)) {
            throw new RuntimeException(String.format("%s sa id-em %n ne postoji", entityType.getSimpleName(), id));
        }

        t = repository.save(t);

        logger.debug("{} with id {} updated: {}", entityType.getSimpleName(), id, t);

        return t;
    }
}

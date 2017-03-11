package slavko.baze2.procesnabavke.services;

import org.springframework.stereotype.Service;
import slavko.baze2.procesnabavke.BaseService;
import slavko.baze2.procesnabavke.domain.JedinicaMere;
import slavko.baze2.procesnabavke.repositories.JedinicaMereRepo;

/**
 * @author Slavko Komarica
 */
@Service
public class JedinicaMereService extends BaseService<JedinicaMere, Long> {

    public JedinicaMereService(JedinicaMereRepo repository) {
        super(repository);
    }
}

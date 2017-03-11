package slavko.baze2.procesnabavke.services;

import org.springframework.stereotype.Service;
import slavko.baze2.procesnabavke.BaseService;
import slavko.baze2.procesnabavke.domain.Ponuda;
import slavko.baze2.procesnabavke.repositories.PonudaRepo;

/**
 * @author Slavko Komarica
 */
@Service
public class PonudaService extends BaseService<Ponuda, Long> {
    protected PonudaService(PonudaRepo repository) {
        super(repository);
    }
}

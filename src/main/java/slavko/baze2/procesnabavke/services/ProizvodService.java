package slavko.baze2.procesnabavke.services;

import org.springframework.stereotype.Service;
import slavko.baze2.procesnabavke.BaseService;
import slavko.baze2.procesnabavke.domain.Proizvod;
import slavko.baze2.procesnabavke.repositories.ProizvodRepo;

/**
 * @author Slavko Komarica
 */
@Service
public class ProizvodService extends BaseService<Proizvod, Long> {

    public ProizvodService(ProizvodRepo proizvodRepo) {
        super(proizvodRepo);
    }
}

package slavko.baze2.procesnabavke.services;

import org.springframework.stereotype.Service;
import slavko.baze2.procesnabavke.BaseService;
import slavko.baze2.procesnabavke.domain.Dobavljac;
import slavko.baze2.procesnabavke.repositories.DobavljacRepo;

/**
 * @author Slavko Komarica
 */
@Service
public class DobavljacService extends BaseService<Dobavljac, Long> {

    public DobavljacService(DobavljacRepo dobavljacRepo) {
        super(dobavljacRepo);
    }
}

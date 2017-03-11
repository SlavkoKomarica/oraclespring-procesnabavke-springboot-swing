package slavko.baze2.procesnabavke.services;

import org.springframework.stereotype.Service;
import slavko.baze2.procesnabavke.BaseService;
import slavko.baze2.procesnabavke.domain.Ugovor;
import slavko.baze2.procesnabavke.repositories.UgovorRepo;

/**
 * @author Slavko Komarica
 */
@Service
public class UgovorService extends BaseService<Ugovor, Long> {

    protected UgovorService(UgovorRepo repository) {
        super(repository);
    }
}

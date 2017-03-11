package slavko.baze2.procesnabavke.services;

import org.springframework.stereotype.Service;
import slavko.baze2.procesnabavke.BaseService;
import slavko.baze2.procesnabavke.domain.Valuta;
import slavko.baze2.procesnabavke.repositories.ValutaRepo;

/**
 * @author Slavko Komarica
 */
@Service
public class ValutaService extends BaseService<Valuta, Long> {

    protected ValutaService(ValutaRepo repository) {
        super(repository);
    }
}

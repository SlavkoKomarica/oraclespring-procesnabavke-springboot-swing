package slavko.baze2.procesnabavke.services;

import org.springframework.stereotype.Service;
import slavko.baze2.procesnabavke.BaseService;
import slavko.baze2.procesnabavke.domain.Narudzbenica;
import slavko.baze2.procesnabavke.repositories.NarudzbenicaRepo;

/**
 * @author Slavko Komarica
 */
@Service
public class NarudzbenicaService extends BaseService<Narudzbenica, Long> {

    public NarudzbenicaService(NarudzbenicaRepo repository) {
        super(repository);
    }
}

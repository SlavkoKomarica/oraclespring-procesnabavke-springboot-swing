package slavko.baze2.procesnabavke.services;

import org.springframework.stereotype.Service;
import slavko.baze2.procesnabavke.BaseService;
import slavko.baze2.procesnabavke.domain.Otpremnica;
import slavko.baze2.procesnabavke.domain.OtpremnicaId;
import slavko.baze2.procesnabavke.repositories.OtpremnicaRepo;

/**
 * @author Slavko Komarica
 */
@Service
public class OtpremnicaService extends BaseService<Otpremnica, OtpremnicaId> {

    public OtpremnicaService(OtpremnicaRepo repository) {
        super(repository);
    }
}

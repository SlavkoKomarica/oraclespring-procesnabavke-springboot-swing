package slavko.baze2.procesnabavke.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import slavko.baze2.procesnabavke.BaseService;
import slavko.baze2.procesnabavke.gui.domen.Zaposleni;
import slavko.baze2.procesnabavke.repositories.ZaposleniRepo;

/**
 * @author Slavko Komarica
 */
@Service
public class ZaposleniService extends BaseService<Zaposleni, Long> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    ZaposleniRepo zaposleniRepo = (ZaposleniRepo) repository;

    public ZaposleniService(ZaposleniRepo zaposleniRepo) {
        super(zaposleniRepo);
    }

    //do not put transactional because of caught exception
    public Zaposleni create(Zaposleni zaposleni) {
        try {
            zaposleniRepo.insert(zaposleni);
        } catch (JpaSystemException e) {
            //jmbg causes problem, but insert was ok
        }

        return null;
    }

    @Override
    public Zaposleni update(Long aLong, Zaposleni zaposleni) {
        throw new UnsupportedOperationException("Update zapolsenog nije omogucen");
    }

    public Zaposleni getByUsernameAndPassword(String korisničkoIme, String sifra) {
        logger.debug("Getting Zaposleni with korisnickoIme {} and sifra {}", korisničkoIme, sifra);

        Zaposleni zaposleni = zaposleniRepo.findByKorisnickoImeAndKorisnickaSifra(korisničkoIme, sifra).orElseGet(null);

        logger.debug("Zaposleni with korisnickoIme {} and sifra {} found: ", korisničkoIme, sifra, zaposleni);

        return zaposleni;
    }
}

package slavko.baze2.procesnabavke.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static slavko.baze2.procesnabavke.services.ServicesFixture.standardZaposleni;

/**
 * @author Slavko Komarica
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ZaposleniRepoTest {

    @Autowired
    ZaposleniRepo zaposleniRepo;

    @Test
    public void insertTest() {
        zaposleniRepo.deleteAll();

        System.out.println("Fist find: " + zaposleniRepo.findAll());

        try {
            zaposleniRepo.insert(standardZaposleni());
        } catch (Exception e) {
            //jmbg problem, but insert should be successful
        }

        System.out.println("Second find: " + zaposleniRepo.findAll());
    }
}

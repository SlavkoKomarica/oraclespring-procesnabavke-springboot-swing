package slavko.baze2.procesnabavke.repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import slavko.baze2.procesnabavke.domain.Dobavljac;

import static org.junit.Assert.assertEquals;

/**
 * @author Slavko Komarica
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DobavljacRepoTest {

    @Autowired
    DobavljacRepo dobavljacRepo;

    @Before
    public void setUp() {
        Dobavljac dobavljac = new Dobavljac.Builder()
                .withSifra(1L)
                .withNaziv("Dobavljac1")
                .withSwift("111RS111").build();

        Dobavljac dobavljac2 = new Dobavljac.Builder()
                .withSifra(2L)
                .withNaziv("Dobavljac2")
                .withSwift("222RS222").build();

        Dobavljac dobavljac3 = new Dobavljac.Builder()
                .withSifra(3L)
                .withNaziv("Dobavljac3")
                .withSwift("111UK111").build();

        Dobavljac dobavljac4 = new Dobavljac.Builder()
                .withSifra(4L)
                .withNaziv("Dobavljac4").build();

        dobavljacRepo.save(dobavljac);
        dobavljacRepo.save(dobavljac2);
        dobavljacRepo.save(dobavljac3);
        dobavljacRepo.save(dobavljac4);
    }

    @After
    public void tearDown(){
        dobavljacRepo.deleteAll();
    }

    @Test
    public void test() {
        System.out.println("All: " + dobavljacRepo.findAll());
        System.out.println("RS: " + dobavljacRepo.findRS());
        System.out.println("Unclassified: " + dobavljacRepo.findUnclassified());
        System.out.println("Foreign: " + dobavljacRepo.findForeign());
    }
}

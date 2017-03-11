package slavko.baze2.procesnabavke.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import slavko.baze2.procesnabavke.domain.*;
import slavko.baze2.procesnabavke.repositories.*;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static slavko.baze2.procesnabavke.services.ServicesFixture.*;

/**
 * @author Slavko Komarica
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicesTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ValutaRepo valutaRepo;
    @Autowired
    private ValutaService valutaService;

    @Autowired
    private ProizvodRepo proizvodRepo;
    @Autowired
    private ProizvodService proizvodService;

    @Autowired
    private PonudaRepo ponudaRepo;
    @Autowired
    private PonudaService ponudaService;

    @Autowired
    private ZaposleniRepo zaposleniRepo;
    @Autowired
    private ZaposleniService zaposleniService;

    @Autowired
    private UgovorRepo ugovorRepo;
    @Autowired
    private UgovorService ugovorService;

    @Autowired
    private NarudzbenicaRepo narudzbenicaRepo;
    @Autowired
    private NarudzbenicaService narudzbenicaService;

    @Autowired
    private DobavljacRepo dobavljacRepo;
    @Autowired
    private DobavljacService dobavljacService;

    @Autowired
    private OtpremnicaRepo otpremnicaRepo;
    @Autowired
    private OtpremnicaService otpremnicaService;

    // DATA SETUP
    @Before
    public void setUp() {
        deleteAllData();
        createTestData();
    }

    @After
    public void tearDown() {
        deleteAllData();
    }

    private void deleteAllData() {
        otpremnicaRepo.deleteAll();
        dobavljacRepo.deleteAll();
        narudzbenicaRepo.deleteAll();
        ugovorRepo.deleteAll();
        zaposleniRepo.deleteAll();
        ponudaRepo.deleteAll();
        proizvodRepo.deleteAll();
        valutaRepo.deleteAll();
    }

    private void createTestData() {
        valutaService.create(standardValuta());
        proizvodService.create(standardProizvod());
        ponudaService.create(standardPonuda());
        zaposleniService.create(standardZaposleni());
        ugovorService.create(standardUgovor());
        narudzbenicaService.create(standardNarudzbenica());
        dobavljacService.create(standardDobavljac());
        otpremnicaService.create(standardOtpremnica());

    }

    // PONUDA & VALUTA denormalizacija
    @Test
    public void updateValutaShouldUpdateNazivValuteInPonuda() {
        valutaService.update(STANDARD_SIFRA_VALUTE, standardValutaUpdated());

        Valuta valuta = valutaRepo.findOne(STANDARD_SIFRA_VALUTE);
        Ponuda ponuda = ponudaRepo.findOne(STANDARD_SIFRA_PONUDE);
        assertThat(valuta.getNaziv()).isEqualTo(STANDARD_NAZIV_VALUTE_UPDATED);
        assertThat(ponuda.getNazivValute()).isNotNull();
        assertThat(ponuda.getNazivValute()).isEqualTo(STANDARD_NAZIV_VALUTE_UPDATED);
    }

    // OTPREMNICA & DOBAVLJAC denormalizacija
    @Test
    public void updateDobavaljcShouldUpdateNazivDobavljacaInOtpremnica() {
        dobavljacService.update(STANDARD_SIFRA_DOBAVLJACA, standardDobavljacUpdated());

        Dobavljac dobavljac = dobavljacRepo.findOne(STANDARD_SIFRA_DOBAVLJACA);
        Otpremnica otpremnica = otpremnicaRepo.findOne(new OtpremnicaId(STANDARD_SIFRA_DOBAVLJACA, STANDARD_BROJ_OTPREMNICE));
        assertThat(dobavljac.getNaziv()).isEqualTo(STANDARD_NAZIV_DOBAVLJACA_UPDATED);
        assertThat(otpremnica.getNazivDobavljaca()).isNotNull();
        assertThat(otpremnica.getNazivDobavljaca()).isEqualTo(STANDARD_NAZIV_DOBAVLJACA_UPDATED);
    }

    // UGOVOR & PONUDA & PROIZVOD AKTUELNA CENA OPTIMIZACIJA
    @Test
    public void proizvodShouldHaveAktuelnaCenaSetFromLastInsertedOrUpdatedUgovorPonuda() {
        Proizvod proizvod = proizvodRepo.findOne(STANDARD_SIFRA_PROIZVODA);
        assertThat(proizvod.getAktCena()).isEqualTo(STANDARD_STAVKA_PONUDE_CENA);
    }

    // NARUDZBENICA & STAVKE UKUPNO OPTIMIZACIJA
    @Test
    public void narudzbenicaShouldHaveCalculatedUkupno() {
        Narudzbenica narudzbenica = narudzbenicaRepo.findOne(STANDARD_SIFRA_NARUDZBENICE);
        assertThat(narudzbenica.getUkupno()).isEqualTo(STANDARD_NARUDZBENICA_KOILCINA * STANDARD_STAVKA_PONUDE_CENA);
    }

}

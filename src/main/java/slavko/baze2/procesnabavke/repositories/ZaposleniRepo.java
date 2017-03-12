package slavko.baze2.procesnabavke.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import slavko.baze2.procesnabavke.BaseRepository;
import slavko.baze2.procesnabavke.gui.domen.Zaposleni;

import java.util.List;
import java.util.Optional;

/**
 * @author Slavko Komarica
 */
public interface ZaposleniRepo extends BaseRepository<Zaposleni, Long> {

    @Override
    @Query(nativeQuery = true, value = "SELECT z.sifra, z.ime, z.prezime, z.jmbg.get() as jmbg, z.k_ime, z.k_sifra FROM ZAPOSLENI z")
    List<Zaposleni> findAll();

    @Override
    @Query(nativeQuery = true, value = "SELECT z.sifra, z.ime, z.prezime, z.jmbg.get() as jmbg, z.k_ime, z.k_sifra FROM ZAPOSLENI z where z.sifra = :id")
    Zaposleni findOne(@Param(value = "id") Long id);

    @Query(nativeQuery = true,
            value = "INSERT into zaposleni(sifra,ime,prezime,jmbg,k_ime,k_sifra) " +
                    "VALUES(:#{#zaposleni.sifra},:#{#zaposleni.ime},:#{#zaposleni.prezime},JMBG_TYPE(:#{#zaposleni.jmbg.jmbg}),:#{#zaposleni.korisnickoIme},:#{#zaposleni.korisnickaSifra})")
    void insert(@Param(value = "zaposleni") Zaposleni zaposleni);

    Optional<Zaposleni> findByKorisnickoImeAndKorisnickaSifra(String korisnickoIme, String sifra);
}

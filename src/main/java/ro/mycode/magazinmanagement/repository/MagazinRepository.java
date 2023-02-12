package ro.mycode.magazinmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.magazinmanagement.model.Magazin;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface MagazinRepository extends JpaRepository<Magazin, Long> {

    @Query("select m from Magazin m where m.anInfiintare > ?1 ")
    Optional<List<Magazin>> getMagazinByAnInfiintare(int an);

    @Query("select m from Magazin m where m.descriere like %?1")
    Optional<List<Magazin>> getMagazinByDescriere(String terminatie);

    @Query("select count(m.nume) from Magazin m where substr(m.nume,1,1) in (?1)")
    int getTotalMagazineCareIncepCu(char litera);

    @Query("select count(m.nume),m.culoareLogo from Magazin m group by m.culoareLogo")
    String [] getMagazinByCuloareLogo();

    @Query("select m from Magazin m where m.anInfiintare < ?1 and m.numarAngajati > ?2")
    Optional<List<Magazin>> getMagazinByAnInfiintareAndNumarAngajati(int anInfiintare, int numarAngajati);

    @Query("select m from Magazin m where m.descriere like %?1 and m.culoareLogo = ?2")
    Optional<List<Magazin>> getMagazinByDescriereAndCuloareLogo(String terminatie, String culoare);

    @Query("select count(m.numarAngajati) from Magazin m where m.numarAngajati between ?1 and ?2")
    int getCountByNumarAngajati(int numarAngajatiMin, int numarAngajatiMax);

    @Query("select m from Magazin m where m.numarAngajati < ?1")
    Optional<List<Magazin>> getMagazinByNumarAngajati(int numarAngajati);

    Optional<Magazin> findByNumarFiscal(int numarFiscal);

    Optional<Magazin> findById(long id);

    @Transactional
    Optional<Magazin> removeMagazinByNumarFiscal(int numarFiscal);

    @Transactional
    @Modifying
    @Query("update Magazin m set m.numarAngajati = ?1 where m.numarFiscal = ?2")
    void updateNumarAngajati(int numarAngajati, int numarFiscal);

    @Transactional
    @Modifying
    @Query("update Magazin m set m.descriere = ?1 where m.numarFiscal = ?2")
    void updateEmail(String email, int numarFiscal);


}

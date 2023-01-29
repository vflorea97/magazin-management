package ro.mycode.magazinmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.magazinmanagement.Model.Magazin;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface MagazinRepository extends JpaRepository<Magazin, Long> {

    @Query("select m from Magazin m where m.anInfiintare > ?1")
    Optional<List<Magazin>> getMagazinByAnInfiintare(int an);

    @Query("select m from Magazin m where m.descriere like %?1")
    Optional<List<Magazin>> getMagazinByDescriere(String terminatie);

    @Query("select count(m.nume) from Magazin m where substr(m.nume,1,1) in (?1)")
    int getTotalMagazineCareIncepCu(char litera);

    @Query("select count(m.nume),m.culoareLogo from Magazin m group by m.culoareLogo")
    String [] getMagazinByCuloareLogo();

    Optional<Magazin> findByNumarFiscal(int numarFiscal);

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

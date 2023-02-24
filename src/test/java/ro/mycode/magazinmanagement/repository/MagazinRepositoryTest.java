package ro.mycode.magazinmanagement.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.mycode.magazinmanagement.MagazinManagementApplication;
import ro.mycode.magazinmanagement.model.Magazin;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MagazinManagementApplication.class)
@Transactional
class MagazinRepositoryTest {

    @Autowired
    MagazinRepository magazinRepository;

    @BeforeEach
    public void clean(){
        magazinRepository.deleteAll();
    }

    @Test
    public void getMagazinByAnInfiintare(){
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        magazinRepository.saveAndFlush(magazin);
        magazinRepository.saveAndFlush(magazin2);
        magazinRepository.saveAndFlush(magazin3);
        magazinRepository.saveAndFlush(magazin4);
        magazinRepository.saveAndFlush(magazin5);
        magazinRepository.saveAndFlush(magazin6);

        List<Magazin> magazins = magazinRepository.getMagazinByAnInfiintare(2005).get();

        assertEquals(magazin5,magazins.get(1));
        assertEquals(magazin6,magazins.get(0));
    }

    @Test
    public void getMagazinByDescriere(){
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        magazinRepository.saveAndFlush(magazin);
        magazinRepository.saveAndFlush(magazin2);
        magazinRepository.saveAndFlush(magazin3);
        magazinRepository.saveAndFlush(magazin4);
        magazinRepository.saveAndFlush(magazin5);
        magazinRepository.saveAndFlush(magazin6);

        List<Magazin> magazins = magazinRepository.getMagazinByDescriere(".com").get();

        assertEquals(true, magazins.contains(magazin));
        assertEquals(true, magazins.contains(magazin2));
    }

    @Test
    public void getTotalMagazineCareIncepCu(){
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        magazinRepository.saveAndFlush(magazin);
        magazinRepository.saveAndFlush(magazin2);
        magazinRepository.saveAndFlush(magazin3);
        magazinRepository.saveAndFlush(magazin4);
        magazinRepository.saveAndFlush(magazin5);
        magazinRepository.saveAndFlush(magazin6);

        int count = magazinRepository.getTotalMagazineCareIncepCu('W');

        assertEquals(2,count);
    }

    @Test
    public void getMagazinByCuloareLogo(){
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        magazinRepository.saveAndFlush(magazin);
        magazinRepository.saveAndFlush(magazin2);
        magazinRepository.saveAndFlush(magazin3);
        magazinRepository.saveAndFlush(magazin4);
        magazinRepository.saveAndFlush(magazin5);
        magazinRepository.saveAndFlush(magazin6);

        String [] magazine = magazinRepository.getMagazinByCuloareLogo();

        assertEquals("2,Aquamarine",magazine[0]);
        assertEquals("1,Mauv",magazine[1]);
        assertEquals("1,Yellow",magazine[2]);
        assertEquals("1,Maroon",magazine[3]);
        assertEquals("1,Green",magazine[4]);
    }

    @Test
    public void getMagazinByAnInfiintareAndNumarAngajati(){
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        magazinRepository.saveAndFlush(magazin);
        magazinRepository.saveAndFlush(magazin2);
        magazinRepository.saveAndFlush(magazin3);
        magazinRepository.saveAndFlush(magazin4);
        magazinRepository.saveAndFlush(magazin5);
        magazinRepository.saveAndFlush(magazin6);

        List<Magazin> magazins = magazinRepository.getMagazinByAnInfiintareAndNumarAngajati(2000,50).get();

        assertEquals(magazin,magazins.get(0));
        assertEquals(magazin2,magazins.get(1));
    }

    @Test
    public void getMagazinByDescriereAndCuloareLogo(){
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        magazinRepository.saveAndFlush(magazin);
        magazinRepository.saveAndFlush(magazin2);
        magazinRepository.saveAndFlush(magazin3);
        magazinRepository.saveAndFlush(magazin4);
        magazinRepository.saveAndFlush(magazin5);
        magazinRepository.saveAndFlush(magazin6);

        List<Magazin> magazins = magazinRepository.getMagazinByDescriereAndCuloareLogo(".com","Mauv").get();

        assertEquals(magazin2,magazins.get(0));
    }

    @Test
    public void getCountByNumarAngajati(){
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        magazinRepository.saveAndFlush(magazin);
        magazinRepository.saveAndFlush(magazin2);
        magazinRepository.saveAndFlush(magazin3);
        magazinRepository.saveAndFlush(magazin4);
        magazinRepository.saveAndFlush(magazin5);
        magazinRepository.saveAndFlush(magazin6);

        int count = magazinRepository.getCountByNumarAngajati(0,200);

        assertEquals(2,count);
    }

    @Test
    public void getMagazinByNumarAngajati(){
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        magazinRepository.saveAndFlush(magazin);
        magazinRepository.saveAndFlush(magazin2);
        magazinRepository.saveAndFlush(magazin3);
        magazinRepository.saveAndFlush(magazin4);
        magazinRepository.saveAndFlush(magazin5);
        magazinRepository.saveAndFlush(magazin6);

        List<Magazin> magazins = magazinRepository.getMagazinByNumarAngajati(700).get();

        assertEquals(true,magazins.contains(magazin));
        assertEquals(true,magazins.contains(magazin2));
        assertEquals(true,magazins.contains(magazin3));

    }

    @Test
    public void findByNumarFiscal(){
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        magazinRepository.saveAndFlush(magazin);
        magazinRepository.saveAndFlush(magazin2);
        magazinRepository.saveAndFlush(magazin3);
        magazinRepository.saveAndFlush(magazin4);
        magazinRepository.saveAndFlush(magazin5);
        magazinRepository.saveAndFlush(magazin6);

        Magazin magazin1 = magazinRepository.findByNumarFiscal(51916).get();

        assertEquals(magazin2, magazin1);
    }

}
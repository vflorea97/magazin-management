package ro.mycode.magazinmanagement.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.mycode.magazinmanagement.comparatori.MagazinComapratorAnInfiintare;
import ro.mycode.magazinmanagement.exceptii.ExceptieMagazinDBEmpty;
import ro.mycode.magazinmanagement.exceptii.ExceptieMagazinExistent;
import ro.mycode.magazinmanagement.exceptii.ExceptieMagazinNecorespunzator;
import ro.mycode.magazinmanagement.exceptii.ExceptieMagazinNeexistent;
import ro.mycode.magazinmanagement.model.Magazin;
import ro.mycode.magazinmanagement.repository.MagazinRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MagazinServiceTest {

    @Mock
    private MagazinRepository magazinRepository;

    @InjectMocks
    private MagazinService magazinService;

    @Captor
    ArgumentCaptor<Magazin> magazinArgumentCaptor;
    @Captor
    ArgumentCaptor<Integer> magazinField1;
    @Captor
    ArgumentCaptor<Integer> magazinField2;
    @Captor
    ArgumentCaptor<String> magazinField3;

    @Test
    void getAllMagazine() {
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        List<Magazin> magazine = new ArrayList<>();
        magazine.add(magazin);
        magazine.add(magazin2);
        magazine.add(magazin3);
        magazine.add(magazin4);
        magazine.add(magazin5);
        magazine.add(magazin6);

        doReturn(magazine).when(magazinRepository).findAll();
        assertEquals(6,magazinService.getAllMagazine().size());
    }
    @Test
    void gelAllMagazineExceptie() {
        List<Magazin> magazins = new ArrayList<>();
        doReturn(magazins).when(magazinRepository).findAll();
        assertThrows(ExceptieMagazinDBEmpty.class, () ->{
            magazinService.getAllMagazine();
        });
    }

    @Test
    void addMagazin() {
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();

        doReturn(Optional.empty()).when(magazinRepository).findByNumarFiscal(40594);

        magazinService.addMagazin(magazin);

        verify(magazinRepository, times(1)).saveAndFlush(magazinArgumentCaptor.capture());

        assertEquals(magazinArgumentCaptor.getValue(),magazin);
    }
    @Test
    void addMagazinExceptie() {
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        doReturn(Optional.of(magazin)).when(magazinRepository).findByNumarFiscal(40594);
        assertThrows(ExceptieMagazinExistent.class, () ->{
            magazinService.addMagazin(magazin);
        });
    }

    @Test
    void removeMagazin() {
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();

        doReturn(Optional.of(magazin)).when(magazinRepository).findByNumarFiscal(40594);

        magazinService.removeMagazin(40594);

        verify(magazinRepository, times(1)).removeMagazinByNumarFiscal(magazinField2.capture());

        assertEquals(40594, magazinField2.getValue());
    }
    @Test
    void removeMagazinExceptie() {
        doReturn(Optional.empty()).when(magazinRepository).findByNumarFiscal(40594);
        assertThrows(ExceptieMagazinNeexistent.class,() ->{
            magazinService.removeMagazin(40594);
        });
    }

    @Test
    void updateNumarAngajati() {
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();

        doReturn(Optional.of(magazin)).when(magazinRepository).findByNumarFiscal(40594);

        magazinService.updateNumarAngajati(1000,40594);

        verify(magazinRepository, times(1)).updateNumarAngajati(magazinField1.capture(),magazinField2.capture());

        assertEquals(1000,magazinField1.getValue());
        assertEquals(40594,magazinField2.getValue());
    }
    @Test
    void updateNumarAngajatiExceptie() {
        doReturn(Optional.empty()).when(magazinRepository).findByNumarFiscal(40594);

        assertThrows(ExceptieMagazinNeexistent.class, () ->{
           magazinService.updateNumarAngajati(1000, 40594);
        });
    }

    @Test
    void updateEmail() {
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("test@gmail.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();

        doReturn(Optional.of(magazin)).when(magazinRepository).findByNumarFiscal(40594);

        magazinService.updateEmail("test@gmail.com", 40594);

        verify(magazinRepository, times(1)).updateEmail(magazinField3.capture(), magazinField1.capture());

        assertEquals("test@gmail.com", magazinField3.getValue());
        assertEquals(40594,magazinField1.getValue());
    }
    @Test
    void updateEmailExceptie() {
        doReturn(Optional.empty()).when(magazinRepository).findByNumarFiscal(40594);

        assertThrows(ExceptieMagazinNeexistent.class, () ->{
            magazinService.updateEmail("test@gmail.com", 40594);
        });
    }

    @Test
    void getMagazinByAnInfiintare() {
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        List<Magazin> magazine = new ArrayList<>();
        magazine.add(magazin);
        magazine.add(magazin2);
        magazine.add(magazin3);
        magazine.add(magazin4);
        magazine.add(magazin5);
        magazine.add(magazin6);

        Collections.sort(magazine, new MagazinComapratorAnInfiintare());
        doReturn(Optional.of(magazine)).when(magazinRepository).getMagazinByAnInfiintare(2000);
        magazinService.getMagazinByAnInfiintare(2000);

        assertEquals(magazin4, magazine.get(3));
    }
    @Test
    void getMagazineByAnInfiintareExceptie() {
        List<Magazin> magazins = new ArrayList<>();

        doReturn(Optional.of(magazins)).when(magazinRepository).getMagazinByAnInfiintare(2000);

        assertThrows(ExceptieMagazinNecorespunzator.class, () ->{
            magazinService.getMagazinByAnInfiintare(2000);
        });
    }

    @Test
    void getMagazinByDescriere() {
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("test@gmail.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();

        doReturn(Optional.of(magazin)).when(magazinRepository).getMagazinByDescriere("com");

        assertEquals(Optional.of(magazin), magazinService.getMagazinByDescriere("com"));
    }
    @Test
    void getMagazinByDescriereExceptie() {
        doReturn(Optional.empty()).when(magazinRepository).getMagazinByDescriere("com");
        assertThrows(ExceptieMagazinNecorespunzator.class, () ->{
           magazinService.getMagazinByDescriere("com");
        });
    }

    @Test
    void getTotalMagazineCareIncepCu() {
        Magazin magazin = Magazin.builder().anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        List<Magazin> magazine = new ArrayList<>();
        magazine.add(magazin);
        magazine.add(magazin2);
        magazine.add(magazin3);
        magazine.add(magazin4);
        magazine.add(magazin5);
        magazine.add(magazin6);

        doReturn(magazine.size()).when(magazinRepository).getTotalMagazineCareIncepCu('A');
        magazinService.getTotalMagazineCareIncepCu('A');

        assertEquals(2,magazine.size());
    }

    @Test
    void getMagazinByCuloareLogo() {
    }

    @Test
    void getMagazinByAnInfiintareAndNumarAngajati() {
    }

    @Test
    void getMagazinByDescriereAndCuloareLogo() {
    }

    @Test
    void getCountByNumarAngajati() {
    }

    @Test
    void removeByNumarAngajati() {
    }

    @Test
    void updateMagazin() {
    }
}
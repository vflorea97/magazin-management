package ro.mycode.magazinmanagement.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ro.mycode.magazinmanagement.dto.MagazinDTO;
import ro.mycode.magazinmanagement.model.Magazin;
import ro.mycode.magazinmanagement.service.MagazinService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class MagazinResourceTest {

    @Mock
    private MagazinService magazinService;

    @InjectMocks
    private MagazinResource magazinResource;

    private ObjectMapper mapper = new ObjectMapper();

    private MockMvc restMockMvc;

    @BeforeEach
    void initialConfig() {
        restMockMvc = MockMvcBuilders.standaloneSetup(magazinResource).build();
    }
    @Captor
    ArgumentCaptor<Magazin> magazinArgumentCaptor;
    @Captor
    ArgumentCaptor<MagazinDTO> magazinDTOArgumentCaptor;

    @Test
    void getAllMagazine() throws Exception{
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

        doReturn(magazine).when(magazinService).getAllMagazine();

        restMockMvc.perform(get("http://localhost:3000/api/v1/magazine")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(magazine)));
    }

    @Test
    void getMagazinByAnInfiintare() throws Exception{
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

        doReturn(magazine).when(magazinService).getMagazinByAnInfiintare(2000);

        restMockMvc.perform(get("http://localhost:3000/api/v1/magazine/getMagazinByAnInfiintare")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(magazine)));
    }

    @Test
    void getMagazinByDescriere() throws Exception{
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

        doReturn(magazine).when(magazinService).getMagazinByDescriere(".com");

        restMockMvc.perform(get("http://localhost:3000/api/v1/magazine/getMagazinByDescriere")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(magazine)));
    }

    @Test
    void getTotalMagazineCareIncepCu() throws Exception {
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

        int numarMagazine = 0;

        doReturn(numarMagazine).when(magazinService).getTotalMagazineCareIncepCu('B');

        restMockMvc.perform(get("http://localhost:3000/api/v1/magazine/getTotalMagazineCareIncepCu")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(numarMagazine)));
    }

    @Test
    void getMagazinByCuloareLogo() throws Exception {
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

        String [] magLog = new String[10];

        doReturn(magLog).when(magazinService).getMagazinByCuloareLogo();

        restMockMvc.perform(get("http://localhost:3000/api/v1/magazine/getMagazinByCuloareLogo")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(magLog)));
    }

    @Test
    void getMagazinById() throws Exception {
        Magazin magazin = Magazin.builder().id(10L).anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().id(11L).anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().id(12L).anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().id(13L).anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().id(14L).anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().id(15L).anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        List<Magazin> magazine = new ArrayList<>();
        magazine.add(magazin);
        magazine.add(magazin2);
        magazine.add(magazin3);
        magazine.add(magazin4);
        magazine.add(magazin5);
        magazine.add(magazin6);

        Optional<Magazin> magazin1 = Optional.empty();

        doReturn(magazin1).when(magazinService).getMagazinById(12L);

        restMockMvc.perform(get("http://localhost:3000/api/v1/magazine/getById/12")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(magazin1)));
    }

    @Test
    void getMagazinByDescriereAndCuloareLogo() throws Exception {
        Magazin magazin = Magazin.builder().id(10L).anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().id(11L).anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().id(12L).anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().id(13L).anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().id(14L).anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().id(15L).anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        List<Magazin> magazine = new ArrayList<>();
        magazine.add(magazin);
        magazine.add(magazin2);
        magazine.add(magazin3);
        magazine.add(magazin4);
        magazine.add(magazin5);
        magazine.add(magazin6);

        doReturn(magazine).when(magazinService).getMagazinByDescriereAndCuloareLogo(".com","Green");

        restMockMvc.perform(get("http://localhost:3000/api/v1/magazine/getMagazinByDescriereAndCuloareLogo?terminatie=.com&culoare=Green")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(magazine)));
    }

    @Test
    void getCountByNumarAngajati() throws Exception {
        Magazin magazin = Magazin.builder().id(10L).anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().id(11L).anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().id(12L).anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().id(13L).anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().id(14L).anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().id(15L).anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        List<Magazin> magazine = new ArrayList<>();
        magazine.add(magazin);
        magazine.add(magazin2);
        magazine.add(magazin3);
        magazine.add(magazin4);
        magazine.add(magazin5);
        magazine.add(magazin6);

        int count = 0;

        doReturn(count).when(magazinService).getCountByNumarAngajati(500,800);

        restMockMvc.perform(get("http://localhost:3000/api/v1/magazine/getCountByNumarAngajati?numarAngajatiMin=500&numarAngajatiMax=800")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(count)));
    }

    @Test
    void addMagazin() throws Exception{
        Magazin magazin = Magazin.builder().id(10L).anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();

        restMockMvc.perform(post("http://localhost:3000/api/v1/add")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(mapper.writeValueAsBytes(magazin)))
                .andExpect(status().isCreated())
                .andExpect(content().string(mapper.writeValueAsString(magazin)));

        verify(magazinService, times(1)).addMagazin(magazinArgumentCaptor.capture());

        assertEquals(magazin, magazinArgumentCaptor.getValue());
    }

    @Test
    void removeMagazin() throws Exception{
        Magazin magazin = Magazin.builder().id(10L).anInfiintare(1988).culoareLogo("Aquamarine").descriere("test@gmail.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();

        restMockMvc.perform(delete("http://localhost:3000/api/v1/magazin/remove?numarFiscal=40594")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string("Ai sters cu succes"))
                .andExpect(status().isAccepted());

        assertEquals(Optional.empty(), magazinService.getMagazinByNumarFiscal(40594));
    }

    @Test
    void removeMagazinByNumarAngajati() throws Exception{
        Magazin magazin = Magazin.builder().id(10L).anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        Magazin magazin2 = Magazin.builder().id(11L).anInfiintare(1993).culoareLogo("Mauv").descriere("csamwaye1@multiply.com").numarAngajati(70).numarFiscal(51916).nume("Hickle-Runte").build();
        Magazin magazin3 = Magazin.builder().id(12L).anInfiintare(2002).culoareLogo("Yellow").descriere("tlohan2@ow.ly").numarAngajati(668).numarFiscal(92708).nume("Glover Inc").build();
        Magazin magazin4 = Magazin.builder().id(13L).anInfiintare(2001).culoareLogo("Maroon").descriere("kcarlyle3@google.com.au").numarAngajati(788).numarFiscal(50139).nume("Wintheiser, Hauck and Conn").build();
        Magazin magazin5 = Magazin.builder().id(14L).anInfiintare(2007).culoareLogo("Aquamarine").descriere("mgenney4@cam.ac.uk").numarAngajati(757).numarFiscal(53311).nume("McGlynn-Morissette").build();
        Magazin magazin6 = Magazin.builder().id(15L).anInfiintare(2011).culoareLogo("Green").descriere("jzimmermeister5@soup.io").numarAngajati(780).numarFiscal(28702).nume("Walsh LLC").build();

        List<Magazin> magazine = new ArrayList<>();
        magazine.add(magazin);
        magazine.add(magazin2);
        magazine.add(magazin3);
        magazine.add(magazin4);
        magazine.add(magazin5);
        magazine.add(magazin6);

        restMockMvc.perform(delete("http://localhost:3000/api/v1/magazin/removeByNumarAngajati?numarAngajati=500")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string("Ai sters magazinele cu numar de angajati sub 500 cu succes!!"))
                .andExpect(status().isAccepted());

        assertEquals(Optional.empty(), magazinService.getMagazinByNumarFiscal(40594));

    }

    @Test
    void updateMagazin() throws Exception{
        Magazin magazin = Magazin.builder().id(10L).anInfiintare(1988).culoareLogo("Aquamarine").descriere("eroggeman0@prnewswire.com").numarAngajati(158).numarFiscal(40594).nume("Rohan-Gaylord").build();
        MagazinDTO magazinDTO = new MagazinDTO(1L,"MAgazin","Reduceri","Verde",5);

        restMockMvc.perform(put("http://localhost:3000/api/v1/magazin/updateMagazin")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(mapper.writeValueAsBytes(magazinDTO)))
                .andExpect(content().string("Ai updata atributul cu succes"))
                .andExpect(status().isOk());

        verify(magazinService, times(1)).updateMagazin(magazinDTOArgumentCaptor.capture());
        assertEquals(magazinDTOArgumentCaptor.getValue(), magazinDTO);
    }
}
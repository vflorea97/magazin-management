package ro.mycode.magazinmanagement.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.mycode.magazinmanagement.model.Magazin;
import ro.mycode.magazinmanagement.service.MagazinService;

import java.util.List;

@RestController
@Slf4j
public class MagazinResource {

    private MagazinService magazinService;


    public MagazinResource(MagazinService magazinService) {
        this.magazinService = magazinService;
    }



    @GetMapping("api/v1/magazine")//endpoint
    public ResponseEntity<List<Magazin>> getAllMagazin(){
        log.info("REST request to get all magazine");
        List<Magazin> magazine = magazinService.getAllMagazine();
        return  new ResponseEntity<>(magazine, HttpStatus.OK);
    }

    @GetMapping("api/v1/magazine/getMagazinByAnInfiintare")
    public ResponseEntity<List<Magazin>> getMagazinByAnInfiintare(){
        log.info("REST request to get magazine dupa anul 2000");
        List<Magazin> magazine = magazinService.getMagazinByAnInfiintare(2000);
        return new ResponseEntity<>(magazine, HttpStatus.OK);
    }

    @GetMapping("api/v1/magazine/getMagazinByDescriere")
    public ResponseEntity<List<Magazin>> getMagazinByDescriere(){
        log.info("REST request to get magazine cu email-ul '.com'");
        List<Magazin> magazine = magazinService.getMagazinByDescriere(".com");
        return new ResponseEntity<>(magazine, HttpStatus.OK);
    }

    @GetMapping("api/v1/magazine/getTotalMagazineCareIncepCu")
    public ResponseEntity<Integer> getTotalMagazineCareIncepCu(){
        log.info("REST request to get numarul magazinelor care incep cu litera 'B'");
        int numarMagazine = magazinService.getTotalMagazineCareIncepCu('B');
        return new ResponseEntity<>(numarMagazine, HttpStatus.OK);
    }

    @GetMapping("api/v1/magazine/getMagazinByCuloareLogo")
    public ResponseEntity<String []> getMagazinByCuloareLogo(){
        log.info("REST request to get cate magazine au aceeasi culoare si culorile");
        String [] numarMagazine = magazinService.getMagazinByCuloareLogo();
        return new ResponseEntity<>(numarMagazine, HttpStatus.OK);
    }

}

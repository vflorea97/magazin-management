package ro.mycode.magazinmanagement.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.magazinmanagement.model.Magazin;
import ro.mycode.magazinmanagement.service.MagazinService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("api/v1/magazine/getById/{id}")
    public ResponseEntity<Optional<Magazin>> getMagazinById(@PathVariable long id){
        log.info("REST request to get magazin by id ={}",id);
        Optional<Magazin> magazin = magazinService.getMagazinById(id);
        return new ResponseEntity<>(magazin ,HttpStatus.OK);
    }

    @GetMapping("api/v1/magazine/getMagazinByAnInfiintareAndNumarAngajati")
    public ResponseEntity<List<Magazin>>getAllMagazine(@RequestParam int anInfiintare ,@RequestParam int nrAngajati){
        log.info("REST request to get all magazine by an infiintare and numarAngajati");
        List<Magazin> magazine = magazinService.getMagazinByAnInfiintareAndNumarAngajati(anInfiintare, nrAngajati);
        return new ResponseEntity<>(magazine, HttpStatus.OK);
    }

    @GetMapping("api/v1/magazine/getMagazinByDescriereAndCuloareLogo")
    public ResponseEntity<List<Magazin>>getMagazinByDescriereAndCuloareLogo(@RequestParam String terminatie, @RequestParam String culoare){
        log.info("REST request to get all magazine by domain and color");
        List<Magazin> magazine = magazinService.getMagazinByDescriereAndCuloareLogo(terminatie, culoare);
        return new ResponseEntity<>(magazine, HttpStatus.OK);
    }

    @GetMapping("api/v1/magazine/getCountByNumarAngajati")
    public ResponseEntity<Integer> getCountByNumarAngajati(@RequestParam int numarAngajatiMin, @RequestParam int numarAngajatiMax){
        log.info("REST request to get number of magazine with numar angajati intre min and max");
        int magazine = magazinService.getCountByNumarAngajati(numarAngajatiMin, numarAngajatiMax);
        return new ResponseEntity<>(magazine, HttpStatus.OK);
    }

    @PostMapping("api/v1/add")
    public ResponseEntity<Magazin> addMagazin(@Valid @RequestBody  Magazin magazin){

        log.info("Rest api to add a new magain {}",magazin);
        this.magazinService.addMagazin(magazin);

        return new ResponseEntity<>(magazin,HttpStatus.CREATED);
    }

    @DeleteMapping("api/v1/magazin/remove")
    public ResponseEntity<String> removeMagazin(@Valid @RequestParam int numarFiscal){
        log.info("REST request to remove one magazine by numarFisca");
        magazinService.removeMagazin(numarFiscal);
        return new ResponseEntity<>("Ai sters cu succes",HttpStatus.ACCEPTED);
    }

    @DeleteMapping("api/v1/magazin/removeByNumarAngajati")
    public ResponseEntity<String> removeMagazinByNumarAngajati(@Valid @RequestParam int numarAngajati){
        log.info("REST api request to remove all magazine by numarAngajati");
        magazinService.removeByNumarAngajati(numarAngajati);
        return new ResponseEntity<>("Ai sters magazinele cu numar de angajati sub " + numarAngajati + " cu succes!!", HttpStatus.ACCEPTED);


    }
}

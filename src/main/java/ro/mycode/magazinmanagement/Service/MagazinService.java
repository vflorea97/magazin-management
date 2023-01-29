package ro.mycode.magazinmanagement.Service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import ro.mycode.magazinmanagement.Exceptii.ExceptieMagazinExistent;
import ro.mycode.magazinmanagement.Exceptii.ExceptieMagazinNecorespunzator;
import ro.mycode.magazinmanagement.Exceptii.ExceptieMagazinNeexistent;
import ro.mycode.magazinmanagement.Model.Magazin;
import ro.mycode.magazinmanagement.Repository.MagazinRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MagazinService {

    private MagazinRepository magazinRepository;

    public MagazinService(MagazinRepository magazinRepository){
        this.magazinRepository = magazinRepository;
    }

    public void afisareMagazine(){
        List<Magazin> magazine = magazinRepository.findAll();
        magazine.forEach(m-> System.out.println(m));
    }

    @Transactional
    public void addMagazin(Magazin magazin) throws ExceptieMagazinExistent{
        Optional<Magazin> magazin1 = magazinRepository.findByNumarFiscal(magazin.getNumarFiscal());
        if (magazin1.isEmpty()){
            magazinRepository.saveAndFlush(magazin);
        }else {
            throw new ExceptieMagazinExistent();
        }
    }
    @Transactional
    public void removeMagazin(int numarFiscal) throws ExceptieMagazinNeexistent{
        Optional<Magazin> magazin = magazinRepository.findByNumarFiscal(numarFiscal);
        if (magazin.isPresent()){
            magazinRepository.removeMagazinByNumarFiscal(numarFiscal);
        }else {
            throw new ExceptieMagazinNeexistent();
        }
    }
    @Transactional
    @Modifying
    public void updateNumarAngajati(int numarAngajati, int numarFiscal) throws ExceptieMagazinNeexistent{
        Optional<Magazin> magazin = magazinRepository.findByNumarFiscal(numarFiscal);
        if (magazin.isPresent()){
            magazinRepository.updateNumarAngajati(numarAngajati, numarFiscal);
        }else {
            throw new ExceptieMagazinNeexistent();
        }
    }
    @Transactional
    @Modifying
    public void updateEmail(String email, int numarFiscal) throws ExceptieMagazinNeexistent{
        Optional<Magazin> magazin = magazinRepository.findByNumarFiscal(numarFiscal);
        if (magazin.isPresent()){
            magazinRepository.updateEmail(email, numarFiscal);
        }else {
            throw new ExceptieMagazinNeexistent();
        }
    }
    public List<Magazin> getMagazinByAnInfiintare(int an) throws ExceptieMagazinNecorespunzator{
        List<Magazin> magazine = magazinRepository.getMagazinByAnInfiintare(an).get();
        if (magazine.size() > 0){
            return magazine;
        }else {
            throw new ExceptieMagazinNecorespunzator();
        }
    }
    public List<Magazin> getMagazinByDescriere(String terminatie) throws ExceptieMagazinNecorespunzator{
        List<Magazin> magazine = magazinRepository.getMagazinByDescriere(terminatie).get();
        if (magazine.size() > 0){
            return magazine;
        }else {
            throw new ExceptieMagazinNecorespunzator();
        }
    }
    public int getTotalMagazineCareIncepCu(char litera) throws ExceptieMagazinNecorespunzator{
        int numarMagazine = magazinRepository.getTotalMagazineCareIncepCu(litera);
        if (numarMagazine > 0){
            return numarMagazine;
        }else {
            throw new ExceptieMagazinNecorespunzator();
        }
    }
    public String [] getMagazinByCuloareLogo() throws ExceptieMagazinNecorespunzator{
        String [] magazine = magazinRepository.getMagazinByCuloareLogo();
        if (magazine.length > 0){
            return magazine;
        }else {
            throw new ExceptieMagazinNecorespunzator();
        }
    }

}

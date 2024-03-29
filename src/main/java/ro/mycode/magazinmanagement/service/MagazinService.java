package ro.mycode.magazinmanagement.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import ro.mycode.magazinmanagement.dto.MagazinDTO;
import ro.mycode.magazinmanagement.exceptii.ExceptieMagazinDBEmpty;
import ro.mycode.magazinmanagement.exceptii.ExceptieMagazinExistent;
import ro.mycode.magazinmanagement.exceptii.ExceptieMagazinNecorespunzator;
import ro.mycode.magazinmanagement.exceptii.ExceptieMagazinNeexistent;
import ro.mycode.magazinmanagement.model.Magazin;
import ro.mycode.magazinmanagement.repository.MagazinRepository;

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

    public List<Magazin> getAllMagazine() throws ExceptieMagazinDBEmpty {
        List<Magazin> magazine = magazinRepository.findAll();
        if (magazine.size() > 0) {
            return magazine;
        }else {
            throw new ExceptieMagazinDBEmpty();
        }
    }

    public Optional<Magazin> getMagazinById(long id) throws ExceptieMagazinNeexistent{
        Optional<Magazin> magazin = magazinRepository.findById(id);
        if (magazin.isPresent()){
            return magazin;
        }else {
            throw new ExceptieMagazinNeexistent();
        }
    }

    public Optional<Magazin> getMagazinByNumarFiscal(int numarFiscal) throws ExceptieMagazinNeexistent{
        Optional<Magazin> magazin = magazinRepository.findByNumarFiscal(numarFiscal);
        if (magazin.isPresent()){
            return magazin;
        }else{
            throw new ExceptieMagazinNeexistent();
        }
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

    public List<Magazin> getMagazinByAnInfiintareAndNumarAngajati(int anInfiintare, int numarAgajati) throws ExceptieMagazinNecorespunzator{
        List<Magazin> magazine = magazinRepository.getMagazinByAnInfiintareAndNumarAngajati(anInfiintare, numarAgajati).get();
        if (magazine.size() > 0){
            return magazine;
        }else {
            throw new ExceptieMagazinNecorespunzator();
        }
    }

    public List<Magazin> getMagazinByDescriereAndCuloareLogo(String terminatie, String culoare) throws ExceptieMagazinNeexistent{
        List<Magazin> magazine = magazinRepository.getMagazinByDescriereAndCuloareLogo(terminatie, culoare).get();
        if (magazine.size() > 0){
            return magazine;
        }else {
            throw new ExceptieMagazinNeexistent();
        }
    }

    public int getCountByNumarAngajati(int numarAngajatiMin, int numarAngajatiMax) throws ExceptieMagazinNeexistent{
        int numarMagazine = magazinRepository.getCountByNumarAngajati(numarAngajatiMin, numarAngajatiMax);
        if (numarMagazine > 0){
            return numarMagazine;
        }else {
            throw new ExceptieMagazinNeexistent();
        }
    }

    @Transactional
    public void removeByNumarAngajati(int numarAngajati) throws ExceptieMagazinNecorespunzator{
        List<Magazin> magazins = magazinRepository.getMagazinByNumarAngajati(numarAngajati).get();
        if (magazins.size() > 0){
            for (int i = 0; i < magazins.size(); i++){
                removeMagazin(magazins.get(i).getNumarFiscal());
            }
        }else {
            throw new ExceptieMagazinNecorespunzator();
        }
    }

    @Transactional
    @Modifying
    public void updateMagazin(MagazinDTO magazinDTO) throws ExceptieMagazinNeexistent{
        Optional<Magazin> magazin = magazinRepository.findById(magazinDTO.getId());
        if (magazin.isPresent()){
            Magazin m=magazin.get();

            if(!magazinDTO.getNume().equals("")){
                m.setNume(magazinDTO.getNume());
            }
            if (magazinDTO.getNumarAngajati() != 0){
                m.setNumarAngajati(magazinDTO.getNumarAngajati());
            }
            if (!magazinDTO.getDescriere().equals("")){
                m.setDescriere(magazinDTO.getDescriere());
            }
            if (!magazinDTO.getCuloareLogo().equals("")){
                m.setCuloareLogo(magazinDTO.getCuloareLogo());
            }
            magazinRepository.saveAndFlush(m);
        }else{
            throw new ExceptieMagazinNeexistent();
        }

    }

}

package ro.mycode.magazinmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.magazinmanagement.model.Magazin;
import ro.mycode.magazinmanagement.repository.MagazinRepository;
import ro.mycode.magazinmanagement.service.MagazinService;
import ro.mycode.magazinmanagement.view.View;

import java.util.List;

@SpringBootApplication
public class MagazinManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagazinManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(MagazinRepository magazinRepository, MagazinService magazinService, View view){

		return args -> {
//			view.play();
//			List<Magazin> magazine = magazinRepository.getMagazinByAnInfiintareAndNumarAngajati(2000, 100).get();
//			view.play();
//			List<Magazin	> magazine = magazinRepository.getMagazinByAnInfiintare(2000).get();
//			List<Magazin> magazine = magazinRepository.getMagazinByDescriere(".uk").get();
//					for (Magazin m:magazine){
//				System.out.println(m);
//			}
//
//			int numarMagazine = magazinRepository.getTotalMagazineCareIncepCu('B');
//			System.out.println(numarMagazine);

//			String [] magazine = magazinRepository.getMagazinByCuloareLogo();
//			for (int i = 0; i <magazine.length - 1; i++){
//				System.out.println(magazine[i]);
//			}

//			Optional<Magazin> magazin = magazinRepository.findByNumarFiscal(40594);
//			System.out.println(magazin);

//			magazinRepository.removeMagazinByNumarFiscal(40594);
//			System.out.println(magazinRepository.findAll());

//			magazinRepository.updateNumarAngajati(1000,51916);
//			magazinRepository.updateEmail("mailmail@gmail.com",51916);
//			magazinService.afisareMagazine();



//			try {
//				Magazin magazin = Magazin.builder().anInfiintare(2000).culoareLogo("Orange").descriere("dppfood@gmail.com").numarAngajati(150).numarFiscal(23112).nume("BurgerBob").build();
//				magazinService.addMagazin(magazin);
//				System.out.println("Ai adaugat un magazin cu succes!!");
//			}catch (ExceptieMagazinExistent e){
//				System.err.println(e.getMessage());
//			}

//			try {
//				magazinService.removeMagazin(23112);
//			}catch (ExceptieMagazinNeexistent e){
//				System.err.println(e.getMessage());
//			}

//			try {
//				System.out.println(magazinService.getMagazinByAnInfiintare(3000));
//			}catch (ExceptieMagazinNecorespunzator e){
//				System.err.println(e.getMessage());
//			}

//			try {
//				System.out.println(magazinService.getMagazinByDescriere(".com"));
//			}catch (ExceptieMagazinNecorespunzator e){
//				System.err.println(e.getMessage());
//			}

//			try {
//				System.out.println(magazinService.getTotalMagazineCareIncepCu('X'));
//			}catch (ExceptieMagazinNecorespunzator e){
//				System.err.println(e.getMessage());
//			}

//			try {
//				String [] magazine = magazinRepository.getMagazinByCuloareLogo();
//				for (int i = 0; i <magazine.length - 1; i++){
//					System.out.println(magazine[i]);
//				}
//			}catch (ExceptieMagazinNecorespunzator e){
//				System.err.println(e.getMessage());
//			}
		};
	}
}

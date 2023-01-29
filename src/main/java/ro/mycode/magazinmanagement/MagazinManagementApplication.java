package ro.mycode.magazinmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.magazinmanagement.Model.Magazin;
import ro.mycode.magazinmanagement.Repository.MagazinRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MagazinManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagazinManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(MagazinRepository magazinRepository){



		return args -> {

//			List<Magazin> magazine = magazinRepository.getMagazinByAnInfiintare(2000).get();
//			List<Magazin> magazine = magazinRepository.getMagazinByDescriere(".uk").get();
//					for (Magazin m:magazine){
//				System.out.println(m.getNume() + m.getCuloareLogo());
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


			magazinRepository.updateNumarAngajati(1000,51916);
		};
	}
}

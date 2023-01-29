package ro.mycode.magazinmanagement.View;

import org.springframework.stereotype.Component;
import ro.mycode.magazinmanagement.Exceptii.ExceptieMagazinExistent;
import ro.mycode.magazinmanagement.Exceptii.ExceptieMagazinNecorespunzator;
import ro.mycode.magazinmanagement.Exceptii.ExceptieMagazinNeexistent;
import ro.mycode.magazinmanagement.Model.Magazin;
import ro.mycode.magazinmanagement.Service.MagazinService;

import java.util.List;
import java.util.Scanner;

@Component
public class View {

    private MagazinService magazinService;
    private Scanner scanner;

    public View(MagazinService magazinService){
        this.magazinService = magazinService;
        scanner = new Scanner(System.in);
    }

    public void meniu() {
        System.out.println("Apasa 1 pentru a afisa toate magazinele");
        System.out.println("Apasa 2 pentru a adauga un magazin");
        System.out.println("Apasa 3 pentru a sterge un magazin");
        System.out.println("Apasa 4 pentru a afisa magazinele infiintate dupa anul 2000");
        System.out.println("Apasa 5 pentru a afisa magazinele cu terminatia email-lului '.com'");
        System.out.println("Apasa 6 pentru a afisa numarul de magazine care incep cu litera 'B'");
        System.out.println("Apasa 7 pentru a afisa cate magazine au aceeasi culoare la logo, alaturi de culori");

    }

    public void play() {
        boolean run = true;
        meniu();
        while (run) {
            int buton = Integer.parseInt(scanner.nextLine());
            switch (buton) {
                case 1:
                    magazinService.afisareMagazine();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    getMagazinByAnInfiintare();
                    break;
                case 5:
                    getMagazinByDescriere();
                    break;
                case 6:
                    getTotalMagazineCareIncepCu();
                    break;
                case 7:
                    getMagazinByCuloareLogo();
                default:
                    run = false;
                    break;
            }
        }
    }

    public void add(){
        System.out.println("introdu anul de infiintare:");
        int anInfiintare = Integer.parseInt(scanner.nextLine());
        System.out.println("Introdu culoare logo-ului");
        String culaoreLogo = scanner.nextLine();
        System.out.println("Introdu adresa de mail:");
        String email = scanner.nextLine();
        System.out.println("Introdu numarul de angajati:");
        int numarAngajati = Integer.parseInt(scanner.nextLine());
        System.out.println("Introdu numarul fiscal:");
        int numarFiscal = Integer.parseInt(scanner.nextLine());
        System.out.println("Introdu numele firmei:");
        String nume = scanner.nextLine();
        try {
				Magazin magazin = Magazin.builder().anInfiintare(anInfiintare).culoareLogo(culaoreLogo).descriere(email).numarAngajati(numarAngajati).numarFiscal(numarFiscal).nume(nume).build();
				magazinService.addMagazin(magazin);
				System.out.println("Ai daugat un magazin cu succes!!");
			}catch (ExceptieMagazinExistent e){
				System.err.println(e.getMessage());
			}

    }

    public void remove(){
        System.out.println("Introdu numarul fiscal: ");
        int numarFiscal = Integer.parseInt(scanner.nextLine());
        try{
            magazinService.removeMagazin(numarFiscal);

        }catch (ExceptieMagazinNeexistent e){
            System.err.println(e.getMessage());
        }
    }

    public void getMagazinByAnInfiintare(){
        try {
            List<Magazin> magazine = magazinService.getMagazinByAnInfiintare(2000);
            for (int i = 0 ;i < magazine.size(); i++){
                System.out.println(magazine.get(i));
            }
        }catch (ExceptieMagazinNecorespunzator e){
            System.err.println(e.getMessage());
        }
    }

    public void getMagazinByDescriere(){
        try {
            List<Magazin> magazine = magazinService.getMagazinByDescriere(".com");
            for (int i = 0 ;i < magazine.size(); i++){
                System.out.println(magazine.get(i));
            }
        }catch (ExceptieMagazinNecorespunzator e){
            System.err.println(e.getMessage());
        }
    }

    public void getTotalMagazineCareIncepCu(){
        try {
            System.out.println(magazinService.getTotalMagazineCareIncepCu('B'));
        }catch (ExceptieMagazinNecorespunzator e){
            System.err.println(e.getMessage());
        }
    }

    public void getMagazinByCuloareLogo(){
        try {
            String [] magazine = magazinService.getMagazinByCuloareLogo();
            for (int i = 0; i <magazine.length - 1; i++){
                System.out.println(magazine[i]);
            }
        }catch (ExceptieMagazinNecorespunzator e){
            System.err.println(e.getMessage());
        }
    }
}

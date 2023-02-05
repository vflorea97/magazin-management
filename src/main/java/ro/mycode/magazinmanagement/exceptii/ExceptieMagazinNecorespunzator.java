package ro.mycode.magazinmanagement.exceptii;

public class ExceptieMagazinNecorespunzator extends RuntimeException{

    public ExceptieMagazinNecorespunzator() {
        super("Niciun magazin nu corespunde cu criteriile date!!");
    }
}

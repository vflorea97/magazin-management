package ro.mycode.magazinmanagement.Exceptii;

public class ExceptieMagazinNecorespunzator extends RuntimeException{

    public ExceptieMagazinNecorespunzator() {
        super("Niciun magazin nu corespunde cu criteriile date!!");
    }
}

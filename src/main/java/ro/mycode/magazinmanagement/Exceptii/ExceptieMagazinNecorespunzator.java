package ro.mycode.magazinmanagement.Exceptii;

public class ExceptieMagazinNecorespunzator extends RuntimeException{

    public ExceptieMagazinNecorespunzator() {
        super("Nici un magazin nu corespunde cu criteriile date!!");
    }
}

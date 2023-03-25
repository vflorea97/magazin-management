package ro.mycode.magazinmanagement.exceptii;

public class ExceptieMagazinDBEmpty extends RuntimeException{

    public ExceptieMagazinDBEmpty() {
        super("Baza de date este goala!!!");
    }
}

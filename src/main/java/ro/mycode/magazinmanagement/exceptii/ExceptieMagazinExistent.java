package ro.mycode.magazinmanagement.exceptii;

public class ExceptieMagazinExistent extends RuntimeException{

    public ExceptieMagazinExistent() {
        super("Acest magazin exista in baza de date!!");
    }
}

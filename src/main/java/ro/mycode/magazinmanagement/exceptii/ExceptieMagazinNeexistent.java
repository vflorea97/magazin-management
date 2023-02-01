package ro.mycode.magazinmanagement.exceptii;

public class ExceptieMagazinNeexistent extends RuntimeException{

    public ExceptieMagazinNeexistent() {
        super("Acest magazin nu exista in baza de date!!");
    }
}

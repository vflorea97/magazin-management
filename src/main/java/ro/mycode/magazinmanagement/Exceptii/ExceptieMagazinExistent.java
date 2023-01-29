package ro.mycode.magazinmanagement.Exceptii;

public class ExceptieMagazinExistent extends RuntimeException{

    public ExceptieMagazinExistent() {
        super("Acest magazin exista in baza de date!!");
    }
}

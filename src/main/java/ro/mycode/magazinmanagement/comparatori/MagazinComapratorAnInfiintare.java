package ro.mycode.magazinmanagement.comparatori;

import ro.mycode.magazinmanagement.model.Magazin;

import java.util.Comparator;

public class MagazinComapratorAnInfiintare implements Comparator<Magazin> {
    @Override
    public int compare(Magazin magazin, Magazin t1) {
        return Integer.compare(t1.getAnInfiintare(),magazin.getAnInfiintare());
    }
}

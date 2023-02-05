package ro.mycode.magazinmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Entity(name="Magazin")
@Table(name="magazine")
public class Magazin implements Comparable<Magazin>{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id

    private Long id;
    private String nume;
    private String descriere;
    private String culoareLogo;
    private int anInfiintare;
    private int numarAngajati;
    private int numarFiscal;

    @Override
    public int compareTo(Magazin magazin) {
        if (this.numarFiscal > magazin.numarFiscal){
            return 1;
        }
        if (this.numarFiscal < magazin.numarFiscal){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public boolean equals(Object o){
        Magazin magazin = (Magazin) o;
        return this.numarFiscal == magazin.numarFiscal;
    }
}

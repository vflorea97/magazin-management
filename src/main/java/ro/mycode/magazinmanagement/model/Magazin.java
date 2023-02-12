package ro.mycode.magazinmanagement.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Entity(name="Magazin")
@Table(name="magazine")
@Getter
@Setter
public class Magazin implements Comparable<Magazin>{

    @Id
    @SequenceGenerator(name = "magazin_sequence", sequenceName = "magazin_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "magazin_sequence")

    private Long id;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "descriere", nullable = false)
    @Size(min = 10,message = "Emailul trebue sa fie de minim 10 caractere")
    private String descriere;

    @Column(name = "culoare_logo", nullable = false)
    @Size(max = 20)
    private String culoareLogo;

    @Column(name = "an_infiintare", nullable = false)
    @Min(value = 1950, message = "Firmele inregistrate trebuie sa fie infiintate dupa anul 1950")
    private int anInfiintare;


    @Column(name = "numar_angajati", nullable = false)
    @Max(value = 2000, message = "Numarul maxim de angajati este 2000")
    private int numarAngajati;

    @Column(name = "numar_fiscal", nullable = false)
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

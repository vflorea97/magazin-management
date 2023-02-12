package ro.mycode.magazinmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MagazinDTO {


    @NotNull
    private Long id;
    private String nume="";
    private String descriere="";
    private String culoareLogo="";
    private int numarAngajati=0;
}

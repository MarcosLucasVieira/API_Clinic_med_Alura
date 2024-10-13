package Clinic.med.API.medicals;

import Clinic.med.API.adress.DataAdress;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicaslUpdateData(
        @NotNull
        Long id,

        String nome,
        String telefone,
        DataAdress endereco){


}

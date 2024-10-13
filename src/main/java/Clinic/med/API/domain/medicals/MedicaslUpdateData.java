package Clinic.med.API.domain.medicals;

import Clinic.med.API.domain.adress.DataAdress;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicaslUpdateData(
        @NotNull
        Long id,

        String nome,
        String telefone,
        DataAdress endereco){


}

package Clinic.med.API.nurses;

import Clinic.med.API.adress.DataAdress;
import jakarta.validation.constraints.NotNull;

public record NurseUpdateData(
        @NotNull
        Long id,

        String nome,
        String telefone,
        DataAdress endereco) {
}

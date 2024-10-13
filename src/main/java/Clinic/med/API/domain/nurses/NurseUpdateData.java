package Clinic.med.API.domain.nurses;

import Clinic.med.API.domain.adress.DataAdress;
import jakarta.validation.constraints.NotNull;

public record NurseUpdateData(
        @NotNull
        Long id,

        String nome,
        String telefone,
        DataAdress endereco) {
}

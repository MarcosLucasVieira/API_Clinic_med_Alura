package Clinic.med.API.domain.patients;

import Clinic.med.API.domain.adress.DataAdress;
import jakarta.validation.constraints.NotNull;

public record PatientsUpdateData(
        @NotNull
        Long id,

        String nome,

        String telefone,

        DataAdress endereco) {
}

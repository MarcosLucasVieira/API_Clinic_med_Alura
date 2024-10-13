package Clinic.med.API.patients;

import Clinic.med.API.adress.DataAdress;
import jakarta.validation.constraints.NotNull;

public record PatientsUpdateData(
        @NotNull
        Long id,

        String nome,

        String telefone,

        DataAdress endereco) {
}

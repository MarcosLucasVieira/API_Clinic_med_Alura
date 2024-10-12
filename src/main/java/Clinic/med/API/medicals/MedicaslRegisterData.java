package Clinic.med.API.medicals;

import Clinic.med.API.adress.DataAdress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicaslRegisterData(
        @NotBlank
        String nome,

        @NotBlank @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Specialty especialidade,

        @NotNull @Valid
        DataAdress endereco ) {
}

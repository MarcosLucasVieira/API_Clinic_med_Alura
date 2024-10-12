package Clinic.med.API.nurses;

import Clinic.med.API.adress.DataAdress;
import Clinic.med.API.medicals.Specialty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegisterNursesData(

        @NotBlank
        String nome,

        @NotBlank @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String coren,

        @NotNull @Valid
        DataAdress endereco) {
}

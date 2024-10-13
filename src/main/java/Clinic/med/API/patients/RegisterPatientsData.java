package Clinic.med.API.patients;

import Clinic.med.API.adress.DataAdress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegisterPatientsData(
        @NotBlank
        String nome,

        @NotBlank @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotNull @Valid
        DataAdress endereco)  {
    public static record DataListPatients(Long id, String nome, String email, String cpf ) {
    }
}

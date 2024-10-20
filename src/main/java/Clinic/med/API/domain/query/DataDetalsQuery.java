package Clinic.med.API.domain.query;

import Clinic.med.API.domain.medicals.Specialty;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataDetalsQuery(


        Long idMedical,

        Long IdNurse,

        Long IdPatient,

        LocalDateTime date,



        Specialty especialidade) {
}

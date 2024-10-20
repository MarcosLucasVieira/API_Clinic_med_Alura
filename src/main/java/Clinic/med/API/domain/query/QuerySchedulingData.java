package Clinic.med.API.domain.query;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record QuerySchedulingData(
        Long idMedical,

        Long idNurse,

        @NotNull
        Long idPatient,

         @NotNull
         @Future
         LocalDateTime date) {
}

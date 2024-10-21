package Clinic.med.API.domain.query;


import Clinic.med.API.domain.medicals.Medicals;
import Clinic.med.API.domain.nurses.Nurses;
import Clinic.med.API.domain.patients.patients;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Table(name = "query")
@Entity(name = "query")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Query {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_id")
    private Medicals medicals;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patients_id")
    private patients patients;

    private LocalDateTime date;
}

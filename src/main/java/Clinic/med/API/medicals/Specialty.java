package Clinic.med.API.medicals;

import jakarta.persistence.Embeddable;
import jdk.jfr.Enabled;

@Embeddable
public enum Specialty {

    ORTOPEDIA,
    CARDIOLOGIA,
    GINECOLOGIA,
    DERMATOLOGIA
}

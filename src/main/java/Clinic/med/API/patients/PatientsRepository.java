package Clinic.med.API.patients;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<patients, Long> {
}

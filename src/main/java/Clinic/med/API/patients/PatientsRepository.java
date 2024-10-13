package Clinic.med.API.patients;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<patients, Long> {

    Page<patients> findAllByAtivoTrue(Pageable paginacao);
}

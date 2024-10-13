package Clinic.med.API.medicals;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalsRepository extends JpaRepository<Medicals, Long> {

    Page<Medicals> findAllByAtivoTrue(Pageable paginacao);
}

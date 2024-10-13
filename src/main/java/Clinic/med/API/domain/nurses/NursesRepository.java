package Clinic.med.API.domain.nurses;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NursesRepository extends JpaRepository<Nurses, Long> {

    Page<Nurses> findAllByAtivoTrue(Pageable paginacao);
}

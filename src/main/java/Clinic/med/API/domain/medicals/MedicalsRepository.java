package Clinic.med.API.domain.medicals;

import io.micrometer.observation.ObservationFilter;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicalsRepository extends JpaRepository<Medicals, Long> {

    Page<Medicals> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
        SELECT M FROM medical M
        WHERE M.ativo = true
        AND M.especialidade = :especialidade
        AND M.id NOT IN (
            SELECT q.medicals.id FROM query q
            WHERE q.date = :date
        )
        ORDER BY RAND()
        LIMIT 1
        """)


    Medicals chooseRandoMedicals(Specialty especialidade, @NotNull @Future LocalDateTime date);
}

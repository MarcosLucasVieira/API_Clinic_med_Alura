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
            Select M from medical M
            where 
            M.ativo= true
            and 
            m.especialidade= :especialidade
            and 
            m.id not in(
                select q.medicals.id from query q
                where
                q.createdAt =: createdAt
            )
            order by rand()
            limit 1
""")
    Medicals chooseRandoMedicals(Specialty especialidade, @NotNull @Future LocalDateTime date);
}

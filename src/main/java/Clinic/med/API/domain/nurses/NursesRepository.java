package Clinic.med.API.domain.nurses;

import io.micrometer.observation.ObservationFilter;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface NursesRepository extends JpaRepository<Nurses, Long> {

    Page<Nurses> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
       Select N from nurse  N
       where
       n.ativo = true
       and
       n.id not in (
       select q.nurses.id from query q
       where
       q.createdAt =:  createdAt
       )
       order by rand()
       limit 1
""")
    Nurses chooseRandowNurse(@NotNull @Future LocalDateTime date);
}

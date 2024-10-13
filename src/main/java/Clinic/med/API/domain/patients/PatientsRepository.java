package Clinic.med.API.domain.patients;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<patients, Long> {

    Page<patients> findAllByAtivoTrue(Pageable paginacao);
}

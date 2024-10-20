package Clinic.med.API.controller;


import Clinic.med.API.domain.query.AppointmentQuery;
import Clinic.med.API.domain.query.DataDetalsQuery;
import Clinic.med.API.domain.query.QueryRepository;
import Clinic.med.API.domain.query.QuerySchedulingData;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class   QueryController {

        @Autowired
        private AppointmentQuery agenda;


        @PostMapping
        @Transactional
        public ResponseEntity agendar(@RequestBody @Valid QuerySchedulingData data){
            agenda.agendar(data);
            return ResponseEntity.ok(new DataDetalsQuery( null, null,null, null, null ));
        }
}

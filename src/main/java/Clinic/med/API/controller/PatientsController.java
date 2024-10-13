package Clinic.med.API.controller;

import Clinic.med.API.patients.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientsController {

    @Autowired
    private PatientsRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterPatientsData data, UriComponentsBuilder uriBuilder) {
        var patients = new patients(data);
        repository.save(patients);

        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(patients.getId()).toUri();

        return ResponseEntity.created(uri).body(new PatientsDetailsData(patients));
    }

   @GetMapping
    public ResponseEntity <Page<DataPatientsList>> listar(@PageableDefault(size = 10, sort ={"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DataPatientsList::new);

        return ResponseEntity.ok(page);
   }

   @GetMapping("/{id}")
   public ResponseEntity details (@PathVariable Long id){
        var patients = repository.getReferenceById(id);
        return ResponseEntity.ok(new PatientsDetailsData(patients));
   }

   @PutMapping
   @Transactional
   public ResponseEntity update(@RequestBody @Valid PatientsUpdateData data){
        var patients = repository.getReferenceById(data.id());
        patients.updateInfo(data);

        return ResponseEntity.ok(new PatientsDetailsData(patients)) ;
   }

   @DeleteMapping("{id}")
   @Transactional
   public ResponseEntity delete(@PathVariable Long id){
        var patients = repository.getReferenceById(id);
        patients.delete();

        return ResponseEntity.noContent().build();
   }
}

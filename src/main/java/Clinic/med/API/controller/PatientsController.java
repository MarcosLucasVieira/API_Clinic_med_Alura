package Clinic.med.API.controller;

import Clinic.med.API.patients.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientsController {

    @Autowired
    private PatientsRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid RegisterPatientsData data){
        repository.save(new patients(data));
    }

   @GetMapping
    public Page<DataPatientsList> listar(@PageableDefault(size = 10, sort ={"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DataPatientsList::new);
   }

   @PutMapping
   @Transactional
   public void update(@RequestBody @Valid PatientsUpdateData data){
        var patients = repository.getReferenceById(data.id());
        patients.updateInfo(data);
   }

   @DeleteMapping("{id}")
   @Transactional
   public void delete(@PathVariable Long id){
        var patients = repository.getReferenceById(id);
        patients.delete();
   }
}

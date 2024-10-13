package Clinic.med.API.controller;

import Clinic.med.API.medicals.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicals")
public class MedicalsController {

    @Autowired
    private MedicalsRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid  MedicaslRegisterData data){
        repository.save(new Medicals(data));
    }

    @GetMapping
    public Page<DataListMedicals> listar(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao){
    return repository.findAllByAtivoTrue(paginacao).map(DataListMedicals::new);
    }

    @PutMapping
    @Transactional
    public void update (@RequestBody @Valid MedicaslUpdateData data){
    var doctor = repository.getReferenceById(data.id());
    doctor.updateInfo(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public  void delete (@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.delete();
    }

}



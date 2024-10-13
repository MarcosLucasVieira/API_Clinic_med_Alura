package Clinic.med.API.controller;

import Clinic.med.API.domain.medicals.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicals")
public class MedicalsController {

    @Autowired
    private MedicalsRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid  MedicaslRegisterData data, UriComponentsBuilder uriBuilder) {
        var medical = new Medicals(data);
        repository.save(medical);

        var uri = uriBuilder.path("/medicals/{id}").buildAndExpand(medical.getId()).toUri();

        return ResponseEntity.created(uri).body(new MedicalsDetailsData(medical));
    }

    @GetMapping
    public ResponseEntity <Page<DataListMedicals>> listar(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DataListMedicals::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity details (@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        return ResponseEntity.ok(new MedicalsDetailsData(doctor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update (@RequestBody @Valid MedicaslUpdateData data){
    var doctor = repository.getReferenceById(data.id());
    doctor.updateInfo(data);

    return ResponseEntity.ok(new MedicalsDetailsData(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete (@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.delete();

        return ResponseEntity.noContent().build();
    }



}



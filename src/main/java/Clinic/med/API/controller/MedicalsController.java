package Clinic.med.API.controller;

import Clinic.med.API.medicals.DataListMedicals;
import Clinic.med.API.medicals.Medicals;
import Clinic.med.API.medicals.MedicalsRepository;
import Clinic.med.API.medicals.MedicaslRegisterData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicals")
public class MedicalsController {

    @Autowired
    private MedicalsRepository repository;

    @PostMapping
    public void register(@RequestBody @Valid  MedicaslRegisterData data){
        repository.save(new Medicals(data));
    }

    @GetMapping
    public List<DataListMedicals> listar(){
    return repository.findAll().stream().map(DataListMedicals::new).toList();
    }
}



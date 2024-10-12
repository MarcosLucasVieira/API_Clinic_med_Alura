package Clinic.med.API.controller;

import Clinic.med.API.medicals.DataListMedicals;
import Clinic.med.API.medicals.MedicaslRegisterData;
import Clinic.med.API.nurses.DataListNurses;
import Clinic.med.API.nurses.Nurses;
import Clinic.med.API.nurses.NursesRepository;
import Clinic.med.API.nurses.RegisterNursesData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurses")
public class NursesController {

    @Autowired
    private NursesRepository repository;

    @PostMapping
    public void register(@RequestBody @Valid RegisterNursesData data){
       repository.save(new Nurses(data));
    }

    @GetMapping
    public List<DataListNurses> listar(){
        return repository.findAll().stream().map(DataListNurses::new).toList();
    }
}



package Clinic.med.API.controller;

import Clinic.med.API.medicals.DataListMedicals;
import Clinic.med.API.medicals.MedicaslRegisterData;
import Clinic.med.API.nurses.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<DataListNurses> listar(@PageableDefault(size = 10, sort= {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DataListNurses::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid NurseUpdateData data){
        var nurse = repository.getReferenceById(data.id());
        nurse.updateInfo(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public  void delete (@PathVariable Long id){
        var nurse = repository.getReferenceById(id);
        nurse.delete();
    }
}



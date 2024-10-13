package Clinic.med.API.controller;


import Clinic.med.API.domain.nurses.*;
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
@RequestMapping("/nurses")
public class NursesController {

    @Autowired
    private NursesRepository repository;

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid RegisterNursesData data, UriComponentsBuilder uriBuilder) {
       var nurses = new Nurses(data);
       repository.save(nurses);

       var uri = uriBuilder.path("/nurses/{id}").buildAndExpand(nurses.getId()).toUri();

       return ResponseEntity.created(uri).body(new NursesDetailsData(nurses));

    }

    @GetMapping
    public ResponseEntity<Page<DataListNurses>> listar(@PageableDefault(size = 10, sort= {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DataListNurses::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity details (@PathVariable Long id){
        var nurses = repository.getOne(id);
        return ResponseEntity.ok(new NursesDetailsData(nurses));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid NurseUpdateData data){
        var nurse = repository.getReferenceById(data.id());
        nurse.updateInfo(data);

        return ResponseEntity.ok(new NursesDetailsData(nurse));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public  ResponseEntity delete (@PathVariable Long id){
        var nurse = repository.getReferenceById(id);
        nurse.delete();

        return ResponseEntity.noContent().build();
    }
}



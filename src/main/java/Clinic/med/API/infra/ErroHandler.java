package Clinic.med.API.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity Erro404(){
        return ResponseEntity.notFound().build();
    }
}

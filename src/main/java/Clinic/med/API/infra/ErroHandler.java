package Clinic.med.API.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity Erro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity Erro400(MethodArgumentNotValidException ex){
        var erro = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(erro.stream().map(DataErroValidation::new).toList());
    }

    private record  DataErroValidation (String field, String message ){

        public DataErroValidation (FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}

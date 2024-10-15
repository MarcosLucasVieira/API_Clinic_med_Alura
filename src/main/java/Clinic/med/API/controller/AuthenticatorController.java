package Clinic.med.API.controller;


import Clinic.med.API.domain.user.DataAuthenticator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticatorController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity joinLogin(@RequestBody @Valid DataAuthenticator data){
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var authentication = manager.authenticate(token);

        return  ResponseEntity.ok().build();
    }


}

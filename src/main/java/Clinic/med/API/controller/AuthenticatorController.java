package Clinic.med.API.controller;


import Clinic.med.API.domain.user.DataAuthenticator;
import Clinic.med.API.domain.user.User;
import Clinic.med.API.infra.security.DataTokenJWT;
import Clinic.med.API.infra.security.TokenService;
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

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity joinLogin(@RequestBody @Valid DataAuthenticator data){
        var Authenticationtoken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = manager.authenticate(Authenticationtoken);

        var tokenJWT =  tokenService.generateToken((User) authentication.getPrincipal());

        return  ResponseEntity.ok(new DataTokenJWT(tokenJWT));
    }


}

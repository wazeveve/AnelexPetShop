package bcc.anelex.Anelex.controller;

import bcc.anelex.Anelex.model.entities.Cliente;
import bcc.anelex.Anelex.model.entities.dtos.AuthenticationDTO;
import bcc.anelex.Anelex.model.entities.dtos.LoginResponseDTO;
import bcc.anelex.Anelex.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO authenticationDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.login(), authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Cliente) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}

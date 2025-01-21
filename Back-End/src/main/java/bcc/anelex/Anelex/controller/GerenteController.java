package bcc.anelex.Anelex.controller;

import bcc.anelex.Anelex.dto.LoginRequest;
import bcc.anelex.Anelex.dto.LoginRequestManager;
import bcc.anelex.Anelex.dto.LoginResponse;
import bcc.anelex.Anelex.model.entities.Cliente;
import bcc.anelex.Anelex.model.entities.Gerente;
import bcc.anelex.Anelex.model.services.GerenteService;
import bcc.anelex.Anelex.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("gerente")
public class GerenteController {
    @Autowired
    private GerenteService gerenteService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @GetMapping
    public ResponseEntity<List<Gerente>> pegarGerentes() {
        return ResponseEntity.status(HttpStatus.OK).body(this.gerenteService.read());
    }

    @GetMapping("{id}")
    public ResponseEntity<Gerente> pegarGerente(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.gerenteService.read(id));
    }

    @PostMapping
    public ResponseEntity<Gerente> criaGerente(@RequestBody Gerente gerente) {
        this.gerenteService.create(gerente);
        return ResponseEntity.status(HttpStatus.CREATED).body(gerente);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizaGerente(@PathVariable Long id, @RequestBody Gerente gerente) {

        Gerente gerenteOriginal = this.gerenteService.update(id, gerente);
        return new ResponseEntity(gerenteOriginal, HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Gerente> deletaGerente(@PathVariable Long id) {

        this.gerenteService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginClient(@RequestBody LoginRequestManager loginRequest){
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequest.cpf(), loginRequest.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = this.tokenService.generateTokenManager((Gerente) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponse(((Cliente) auth.getPrincipal()).getUsername(), token));
    }
}
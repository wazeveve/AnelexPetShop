package bcc.anelex.Anelex.controller;

import bcc.anelex.Anelex.dto.LoginRequest;
import bcc.anelex.Anelex.dto.LoginResponse;
import bcc.anelex.Anelex.model.entities.Cliente;
import bcc.anelex.Anelex.model.repositories.ClienteRepository;
import bcc.anelex.Anelex.model.services.ClienteService;
import bcc.anelex.Anelex.model.services.EmailService;
import bcc.anelex.Anelex.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @GetMapping
    public ResponseEntity<List<Cliente>> pegarClientes() {
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.read());
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> pegarCliente(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.read(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> criaCliente(@RequestBody Cliente cliente) {
        this.clienteService.create(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizaCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteOriginal = this.clienteService.update(id, cliente);
        return new ResponseEntity(clienteOriginal, HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cliente> deletaCliente(@PathVariable Long id) {
        this.clienteService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginClient(@RequestBody LoginRequest loginRequest){
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = this.tokenService.generateTokenClient((Cliente) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponse(((Cliente) auth.getPrincipal()).getUsername(), token));
    }
}
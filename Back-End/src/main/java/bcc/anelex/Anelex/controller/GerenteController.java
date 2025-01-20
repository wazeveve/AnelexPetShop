package bcc.anelex.Anelex.controller;

import bcc.anelex.Anelex.dto.LoginRequest;
import bcc.anelex.Anelex.dto.LoginResponse;
import bcc.anelex.Anelex.model.entities.Cliente;
import bcc.anelex.Anelex.model.entities.Gerente;
import bcc.anelex.Anelex.model.repositories.GerenteRepository;
import bcc.anelex.Anelex.model.services.GerenteService;
import bcc.anelex.Anelex.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("gerente")
public class GerenteController {
    @Autowired
    private GerenteService gerenteService;

    @Autowired
    private GerenteRepository gerenteRepository;

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
    public ResponseEntity<LoginResponse> loginClient(@RequestBody LoginRequest loginRequest){
        Cliente cliente = this.gerenteRepository.findByEmail(loginRequest.email()).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

        if(/*passwordEncoder.matches(cliente.getPassword(), loginRequest.password())*/cliente.getPassword().equals(loginRequest.password())){
            String token = this.tokenService.generateTokenClient(cliente);
            return ResponseEntity.ok(new LoginResponse(cliente.getUsername(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
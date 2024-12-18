package bcc.anelex.Pet.Shop.ANELEX.controller;

import bcc.anelex.Pet.Shop.ANELEX.model.entities.Gerente;
import bcc.anelex.Pet.Shop.ANELEX.model.exceptions.GerenteNotFoundException;
import bcc.anelex.Pet.Shop.ANELEX.model.repositories.GerenteRepository;
import bcc.anelex.Pet.Shop.ANELEX.model.services.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("gerente")
public class GerenteController {
    @Autowired
    private GerenteService gerenteService;

    @GetMapping
    public ResponseEntity<List<Gerente>> pegarGerentes() {
        return ResponseEntity.status(HttpStatus.OK).body(this.gerenteService.read());
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
}
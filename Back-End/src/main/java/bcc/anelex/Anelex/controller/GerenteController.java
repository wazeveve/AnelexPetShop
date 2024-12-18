package bcc.anelex.Anelex.controller;

import bcc.anelex.Anelex.model.entities.Gerente;
import bcc.anelex.Anelex.model.services.GerenteService;
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
}
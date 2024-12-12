package bcc.anelex.Pet.Shop.ANELEX.controller;

import bcc.anelex.Pet.Shop.ANELEX.model.entities.Gerente;
import bcc.anelex.Pet.Shop.ANELEX.model.repositories.GerenteRepository;
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
    private GerenteRepository gerenteRepository;

    @GetMapping
    public ResponseEntity<List<Gerente>> pegarGerentes(){
        return ResponseEntity.status(HttpStatus.OK).body(this.gerenteRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Gerente> criaGerente(@RequestBody Gerente gerente){
        this.gerenteRepository.save(gerente);
        return ResponseEntity.status(HttpStatus.CREATED).body(gerente);
    }

    @PutMapping("{id}")
    public ResponseEntity<Gerente> atualizaGerente(@PathVariable Long id, @RequestBody Gerente gerente){
        Optional<Gerente> optional = this.gerenteRepository.findById(id);
        if(optional.isPresent()){
            Gerente gerente1 = (Gerente) optional.get();
            gerente1.setCpf(gerente.getCpf());
            gerente1.setName(gerente.getName());
            gerente1.setEmail(gerente.getEmail());
            gerente1.setPassword(gerente.getPassword());
            this.gerenteRepository.save(gerente);
            return ResponseEntity.status(HttpStatus.CREATED).body(gerente1);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Gerente());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Gerente> deletaGerente(@PathVariable Long id){
        Optional<Gerente> optional = this.gerenteRepository.findById(id);
        if(optional.isPresent()){
            Gerente gerente1 = (Gerente) optional.get();
            this.gerenteRepository.delete(gerente1);
            return ResponseEntity.status(HttpStatus.OK).body(gerente1);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Gerente());
        }
    }
}
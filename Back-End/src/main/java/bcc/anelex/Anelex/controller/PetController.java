package bcc.anelex.Anelex.controller;

import bcc.anelex.Anelex.model.entities.Pet;
import bcc.anelex.Anelex.model.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pet")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> pegaPets() {
        return ResponseEntity.status(HttpStatus.OK).body(this.petService.read());
    }

    @GetMapping("{id}")
    public ResponseEntity<Pet> pegaPet(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.petService.read(id));
    }

    @PostMapping
    public ResponseEntity<Pet> salvaPet(@RequestBody Pet pet) {
        this.petService.create(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(pet);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizaPet(@PathVariable Long id, @RequestBody Pet pet) {
        Pet petOriginal = this.petService.update(id, pet);
        return new ResponseEntity(petOriginal, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletaPet(@PathVariable Long id) {
        this.petService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
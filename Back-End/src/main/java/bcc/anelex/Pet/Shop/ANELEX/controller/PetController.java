package bcc.anelex.Pet.Shop.ANELEX.controller;

import bcc.anelex.Pet.Shop.ANELEX.model.entities.Pet;
import bcc.anelex.Pet.Shop.ANELEX.model.exceptions.PetNotFoundException;
import bcc.anelex.Pet.Shop.ANELEX.model.repositories.PetRepository;
import bcc.anelex.Pet.Shop.ANELEX.model.services.PetService;
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
    public ResponseEntity<List<Pet>> pegaPets(){
        return ResponseEntity.status(HttpStatus.OK).body(this.petService.read());
    }

    @PostMapping
    public ResponseEntity<Pet> salvaPet(@RequestBody Pet pet){
        this.petService.create(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(pet);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizaPet(@PathVariable Long id, @RequestBody Pet pet){
        try{
            Pet petOriginal = this.petService.update(id, pet);
            return new ResponseEntity(petOriginal, HttpStatus.OK);
        } catch (PetNotFoundException pnfe){
            return new ResponseEntity(pnfe.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletaPet(@PathVariable Long id){
        try{
            this.petService.delete(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch( PetNotFoundException pnfe){
            return new ResponseEntity(pnfe.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

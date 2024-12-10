package bcc.anelex.Pet.Shop.ANELEX.controller;

import bcc.anelex.Pet.Shop.ANELEX.model.entities.Pet;
import bcc.anelex.Pet.Shop.ANELEX.model.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pet")
public class PetController {
    @Autowired
    private PetRepository petRepository;

    public ResponseEntity<List<Pet>> pegaPets(){
        return ResponseEntity.status(HttpStatus.OK).body(this.petRepository.findAll());
    }
}

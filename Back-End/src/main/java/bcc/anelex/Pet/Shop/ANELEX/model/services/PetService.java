package bcc.anelex.Pet.Shop.ANELEX.model.services;

import bcc.anelex.Pet.Shop.ANELEX.model.entities.Pet;
import bcc.anelex.Pet.Shop.ANELEX.model.exceptions.PetNotFoundException;
import bcc.anelex.Pet.Shop.ANELEX.model.repositories.PetRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class PetService {
    private PetRepository petRepository;

    public PetService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    public Pet create(Pet pet){
        this.petRepository.save(pet);
        return pet;
    }

    public Pet read(Long id){
        Optional opt = this.petRepository.findById(id);
        if(!opt.isPresent()){
            throw new PetNotFoundException(id);
        }
        return (Pet)opt.get();
    }

    public List<Pet> read(){
        return this.petRepository.findAll();
    }

    public Pet update(Long id, Pet pet) throws PetNotFoundException{
        Pet petOriginal = read(id);
        petOriginal.setName(pet.getName());
        petOriginal.setAge(pet.getAge());
        petOriginal.setDescription(pet.getDescription());
        petOriginal.setPath(pet.getPath());
        petOriginal.setGender(pet.getGender());
        petOriginal.setTipo(pet.getTipo());
        this.petRepository.save(petOriginal);
        return petOriginal;
    }

    public void delete(@PathVariable Long id) throws PetNotFoundException{
        if(!this.petRepository.existsById(id)){
            throw new PetNotFoundException(id);
        }
        this.petRepository.deleteById(id);
    }






}

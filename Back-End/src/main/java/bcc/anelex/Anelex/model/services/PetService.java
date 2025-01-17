package bcc.anelex.Anelex.model.services;

import bcc.anelex.Anelex.model.entities.Pet;
import bcc.anelex.Anelex.model.exceptions.PetNotFoundException;
import bcc.anelex.Anelex.model.repositories.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
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
        Optional<Pet> opt = this.petRepository.findById(id);
        if(opt.isEmpty()){
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
        petOriginal.setClient(pet.getClient());
        petOriginal.setConsulta(pet.getConsulta());
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

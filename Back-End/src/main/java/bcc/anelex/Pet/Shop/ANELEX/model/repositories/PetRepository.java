package bcc.anelex.Pet.Shop.ANELEX.model.repositories;

import bcc.anelex.Pet.Shop.ANELEX.model.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}

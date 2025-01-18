package bcc.anelex.Anelex.model.repositories;

import bcc.anelex.Anelex.model.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}

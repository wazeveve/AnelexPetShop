package bcc.anelex.Pet.Shop.ANELEX.model.repositories;

import bcc.anelex.Pet.Shop.ANELEX.model.entities.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {
}

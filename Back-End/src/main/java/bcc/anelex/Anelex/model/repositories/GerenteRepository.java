package bcc.anelex.Anelex.model.repositories;


import bcc.anelex.Anelex.model.entities.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {
}

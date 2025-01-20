package bcc.anelex.Anelex.model.repositories;


import bcc.anelex.Anelex.model.entities.Cliente;
import bcc.anelex.Anelex.model.entities.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {
    Optional<Gerente> findByEmail(String email);
}

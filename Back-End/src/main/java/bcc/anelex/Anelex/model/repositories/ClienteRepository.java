package bcc.anelex.Anelex.model.repositories;

import bcc.anelex.Anelex.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    UserDetails findByEmail(String email);
}

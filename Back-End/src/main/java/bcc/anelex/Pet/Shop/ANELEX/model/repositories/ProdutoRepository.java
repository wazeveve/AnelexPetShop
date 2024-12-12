package bcc.anelex.Pet.Shop.ANELEX.model.repositories;

import bcc.anelex.Pet.Shop.ANELEX.model.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

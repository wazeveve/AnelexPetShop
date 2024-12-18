package bcc.anelex.Anelex.model.repositories;

import bcc.anelex.Anelex.model.entities.RelatorioVendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RelatorioVendasRepository extends JpaRepository<RelatorioVendas, Long> {
}

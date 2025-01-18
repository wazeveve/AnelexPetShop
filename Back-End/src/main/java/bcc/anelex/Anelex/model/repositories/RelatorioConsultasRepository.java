package bcc.anelex.Anelex.model.repositories;

import bcc.anelex.Anelex.model.entities.RelatorioConsultas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RelatorioConsultasRepository extends JpaRepository<RelatorioConsultas, Long> {
}

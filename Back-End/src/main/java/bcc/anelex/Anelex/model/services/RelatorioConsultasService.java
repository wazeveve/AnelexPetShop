package bcc.anelex.Anelex.model.services;

import bcc.anelex.Anelex.model.entities.RelatorioConsultas;
import bcc.anelex.Anelex.model.exceptions.RelatorioConsultasNotFoundException;
import bcc.anelex.Anelex.model.repositories.RelatorioConsultasRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;

@Service
public class RelatorioConsultasService {
    private RelatorioConsultasRepository relatorioConsultasRepository;

    public RelatorioConsultasService(RelatorioConsultasRepository relatorioConsultasRepository){
        this.relatorioConsultasRepository = relatorioConsultasRepository;
    }

    public RelatorioConsultas create(RelatorioConsultas relatorioConsultas){
        this.relatorioConsultas.save(relatorioConsultas);
        return relatorioConsultas;
    }

    public RelatorioConsultas read(Long id){
        Optional opt = this.relatorioConsultasRepository.findById(id);
        if(!opt.isPresent()){
            throw new RelatorioConsultasNotFoundException(id);
        }
        return (RelatorioConsultas)opt.get();
    }

    public List<RelatorioConsultas> read(){
        return this.relatorioConsultasRepository.findAll();
    }

    public RelatorioConsultas update(Long id, RelatorioConsultas relatorioConsultas) throws RelatorioConsultasNotFoundException{
        RelatorioConsultas relatorioConsultasOriginal = read(id);
        relatorioConsultasOriginal.setCliente(relatorioConsultas.getCliente());
        relatorioConsultas.setProdutos(relatorioConsultas.getProdutos());
        this.relatorioConsultasRepository.save(relatorioConsultasOriginal);
        return relatorioConsultasOriginal;
    }

    public void delete(@PathVariable Long id) throws RelatorioConsultasNotFoundException{
        if(!this.relatorioConsultasRepository.existsById(id)){
            throw new RelatorioConsultasNotFoundException(id);
        }
        this.relatorioConsultasRepository.deleteById(id);
    }
}
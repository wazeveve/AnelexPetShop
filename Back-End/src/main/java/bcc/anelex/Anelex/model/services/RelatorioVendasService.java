package bcc.anelex.Anelex.model.services;

import bcc.anelex.Anelex.model.entities.RelatorioVendas;
import bcc.anelex.Anelex.model.exceptions.RelatorioVendasNotFoundException;
import bcc.anelex.Anelex.model.repositories.RelatorioVendasRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;

@Service
public class RelatorioVendasService {
    private RelatorioVendasRepository relatorioVendasRepository;

    public RelatorioVendasService(RelatorioVendasRepository relatorioVendasRepository){
        this.relatorioVendasRepository = relatorioVendasRepository;
    }

    public RelatorioVendas create(RelatorioVendas relatorioVendas){
        this.relatorioVendasRepository.save(relatorioVendas);
        return relatorioVendas;
    }

    public RelatorioVendas read(Long id){
        Optional opt = this.relatorioVendasRepository.findById(id);
        if(!opt.isPresent()){
            throw new RelatorioVendasNotFoundException(id);
        }
        return (RelatorioVendas)opt.get();
    }

    public List<RelatorioVendas> read(){
        return this.relatorioVendasRepository.findAll();
    }

    public RelatorioVendas update(Long id, RelatorioVendas relatorioVendas) throws RelatorioVendasNotFoundException{
        RelatorioVendas relatorioVendasOriginal = read(id);
        relatorioVendasOriginal.setCliente(relatorioVendas.getCliente());
        relatorioVendasOriginal.setProdutos(relatorioVendas.getProdutos());
        this.relatorioVendasRepository.save(relatorioVendasOriginal);
        return relatorioVendasOriginal;
    }

    public void delete(@PathVariable Long id) throws RelatorioVendasNotFoundException{
        if(!this.relatorioVendasRepository.existsById(id)){
            throw new RelatorioVendasNotFoundException(id);
        }
        this.relatorioVendasRepository.deleteById(id);
    }
}
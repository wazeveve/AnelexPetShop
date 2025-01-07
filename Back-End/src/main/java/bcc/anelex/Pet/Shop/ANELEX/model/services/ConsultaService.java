package bcc.anelex.Pet.Shop.ANELEX.model.services;


import bcc.anelex.Pet.Shop.ANELEX.model.entities.Consulta;
import bcc.anelex.Pet.Shop.ANELEX.model.exceptions.ConsultaNotFoundException;
import bcc.anelex.Pet.Shop.ANELEX.model.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    ConsultaRepository consultaRepository;
    public ConsultaService(ConsultaRepository consultaRepository){
        this.consultaRepository = consultaRepository;
    }

    public Consulta create(Consulta consulta){
        this.consultaRepository.save(consulta);
        return consulta;
    }

    public Consulta read(Long id){
        Optional opt = this.consultaRepository.findById(id);
        if(!opt.isPresent()){
            throw new ConsultaNotFoundException(id);
        }
        return (Consulta)opt.get();
    }

    public List<Consulta> read(){
        return this.consultaRepository.findAll();
    }

    public Consulta update(Long id, Consulta consulta) throws ConsultaNotFoundException{
        Consulta consultaOriginal = read(id);
        consultaOriginal.setData(consulta.getData());
        consultaOriginal.setClienteNome(consulta.getClienteNome());
        consultaOriginal.setPetNome(consulta.getPetNome());
        consultaOriginal.setValorConsulta(consulta.getValorConsulta());
        this.consultaRepository.save(consultaOriginal);
        return consultaOriginal;
    }

    public void delete(@PathVariable Long id) throws ConsultaNotFoundException{
        if(!this.consultaRepository.existsById(id)){
            throw new ConsultaNotFoundException(id);
        }
        this.consultaRepository.deleteById(id);
    }

}

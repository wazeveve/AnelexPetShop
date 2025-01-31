package bcc.anelex.Anelex.model.services;

import bcc.anelex.Anelex.model.entities.Gerente;
import bcc.anelex.Anelex.model.entities.role.Role;
import bcc.anelex.Anelex.model.exceptions.GerenteNotFoundException;
import bcc.anelex.Anelex.model.repositories.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class GerenteService {
    @Autowired
    private GerenteRepository gerenteRepository;

    public Gerente create(Gerente gerente){
        gerente.setRole(Role.ADMIN);
        this.gerenteRepository.save(gerente);
        return gerente;
    }

    public Gerente read(Long id){
        Optional opt = this.gerenteRepository.findById(id);
        if(!opt.isPresent()){
            throw new GerenteNotFoundException(id);
        }
        return (Gerente)opt.get();
    }

    public List<Gerente> read(){
        return this.gerenteRepository.findAll();
    }

    public Gerente update(Long id, Gerente gerente) throws GerenteNotFoundException{
        Gerente gerenteOriginal = read(id);
        gerenteOriginal.setCpf(gerente.getCpf());
        gerenteOriginal.setEmail(gerente.getEmail());
        gerenteOriginal.setName(gerente.getName());
        gerenteOriginal.setPassword(new BCryptPasswordEncoder().encode(gerente.getPassword()));
        gerenteOriginal.setTelephone(gerente.getTelephone());
        gerenteOriginal.setRole(Role.ADMIN);
        this.gerenteRepository.save(gerenteOriginal);
        return gerenteOriginal;
    }

    public void delete(@PathVariable Long id) throws GerenteNotFoundException{
        if(!this.gerenteRepository.existsById(id)){
            throw new GerenteNotFoundException(id);
        }
        this.gerenteRepository.deleteById(id);
    }
}

package bcc.anelex.Anelex.model.services;

import bcc.anelex.Anelex.model.entities.Gerente;
import bcc.anelex.Anelex.model.entities.security.Role;
import bcc.anelex.Anelex.model.exceptions.GerenteNotFoundException;
import bcc.anelex.Anelex.model.repositories.GerenteRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class GerenteService {
    private GerenteRepository gerenteRepository;

    public GerenteService(GerenteRepository gerenteRepository){
        this.gerenteRepository = gerenteRepository;
    }

    public Gerente create(Gerente gerente){
        String encryptedPassword = new BCryptPasswordEncoder().encode(gerente.getPassword());
        gerente.setPassword(encryptedPassword);
        gerente.setRole(Role.MANAGER);
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
        String encryptedPassword = new BCryptPasswordEncoder().encode(gerente.getPassword());
        gerenteOriginal.setCpf(gerente.getCpf());
        gerenteOriginal.setEmail(gerente.getEmail());
        gerenteOriginal.setName(gerente.getName());
        gerenteOriginal.setPassword(encryptedPassword);
        gerenteOriginal.setTelephone(gerente.getTelephone());
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

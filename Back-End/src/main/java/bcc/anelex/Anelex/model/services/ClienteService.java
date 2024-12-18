package bcc.anelex.Anelex.model.services;


import bcc.anelex.Anelex.model.entities.Cliente;
import bcc.anelex.Anelex.model.exceptions.ClienteNotFoundException;
import bcc.anelex.Anelex.model.repositories.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente create(Cliente cliente){
        this.clienteRepository.save(cliente);
        return cliente;
    }

    public Cliente read(Long id){
        Optional opt = this.clienteRepository.findById(id);
        if(!opt.isPresent()){
            throw new ClienteNotFoundException(id);
        }
        return (Cliente)opt.get();
    }

    public List<Cliente> read(){
        return this.clienteRepository.findAll();
    }

    public Cliente update(Long id, Cliente cliente) throws ClienteNotFoundException{
        Cliente clienteOriginal = read(id);
        clienteOriginal.setUsername(cliente.getUsername());
        clienteOriginal.setEmail(cliente.getEmail());
        clienteOriginal.setName(cliente.getName());
        clienteOriginal.setPassword(cliente.getPassword());
        clienteOriginal.setTelephone(cliente.getTelephone());
        this.clienteRepository.save(clienteOriginal);
        return clienteOriginal;
    }

    public void delete(@PathVariable Long id) throws ClienteNotFoundException{
        if(!this.clienteRepository.existsById(id)){
            throw new ClienteNotFoundException(id);
        }
        this.clienteRepository.deleteById(id);
    }
}
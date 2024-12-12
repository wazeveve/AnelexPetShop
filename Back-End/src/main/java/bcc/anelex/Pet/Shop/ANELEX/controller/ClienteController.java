package bcc.anelex.Pet.Shop.ANELEX.controller;

import bcc.anelex.Pet.Shop.ANELEX.model.entities.Cliente;
import bcc.anelex.Pet.Shop.ANELEX.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<Cliente>> pegarClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Cliente> criaCliente(@RequestBody Cliente cliente){
        this.clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> atualizaCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        Optional<Cliente> optional = this.clienteRepository.findById(id);
        if(optional.isPresent()){
            Cliente cliente1 = (Cliente)optional.get();
            cliente1.setUsername(cliente.getUsername());
            cliente1.setName(cliente.getName());
            cliente1.setEmail(cliente.getEmail());
            cliente1.setPassword(cliente.getPassword());
            this.clienteRepository.save(cliente1);
            return ResponseEntity.status(HttpStatus.CREATED).body(cliente1);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Cliente());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cliente> deletaCliente(@PathVariable Long id){
        Optional<Cliente> optional = this.clienteRepository.findById(id);
        if(optional.isPresent()){
            Cliente cliente1 = (Cliente)optional.get();
            this.clienteRepository.delete(cliente1);
            return ResponseEntity.status(HttpStatus.OK).body(cliente1);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Cliente());
        }
    }
}
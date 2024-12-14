package bcc.anelex.Pet.Shop.ANELEX.controller;

import bcc.anelex.Pet.Shop.ANELEX.model.entities.Cliente;
import bcc.anelex.Pet.Shop.ANELEX.model.exceptions.ClienteNotFoundException;
import bcc.anelex.Pet.Shop.ANELEX.model.repositories.ClienteRepository;
import bcc.anelex.Pet.Shop.ANELEX.model.services.ClienteService;
import org.apache.coyote.Response;
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
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> pegarClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.read());
    }

    @PostMapping
    public ResponseEntity<Cliente> criaCliente(@RequestBody Cliente cliente){
        this.clienteService.create(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizaCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        try{
            Cliente clienteOriginal = this.clienteService.update(id,cliente);
            return new ResponseEntity(clienteOriginal, HttpStatus.OK);
        } catch (ClienteNotFoundException cnfe){
            return new ResponseEntity(cnfe.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cliente> deletaCliente(@PathVariable Long id){
        try {
            this.clienteService.delete(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (ClienteNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
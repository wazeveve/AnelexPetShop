package bcc.anelex.Anelex.controller;

import bcc.anelex.Anelex.model.entities.Cliente;
import bcc.anelex.Anelex.model.services.ClienteService;
import bcc.anelex.Anelex.model.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EmailService emailService;

    @GetMapping
    public ResponseEntity<List<Cliente>> pegarClientes() {
        emailService.agendaEmailTexto("jean.francisco@alunos.ifsuldeminas.edu.br", "Envio de email", "Deu certo 2!!!", LocalDateTime.now().plusMinutes(1));
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.read());
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> pegarCliente(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.read(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> criaCliente(@RequestBody Cliente cliente) {
        this.clienteService.create(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizaCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteOriginal = this.clienteService.update(id, cliente);
        return new ResponseEntity(clienteOriginal, HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cliente> deletaCliente(@PathVariable Long id) {
        this.clienteService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
package bcc.anelex.Anelex.controller;

import bcc.anelex.Anelex.model.entities.Cliente;
import bcc.anelex.Anelex.model.entities.Consulta;
import bcc.anelex.Anelex.model.services.ClienteService;
import bcc.anelex.Anelex.model.services.ConsultaService;
import bcc.anelex.Anelex.model.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consulta")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EmailService emailService;

    @GetMapping
    public ResponseEntity<List<Consulta>> pegarConsultas() {
        return ResponseEntity.status(HttpStatus.OK).body(this.consultaService.read());
    }

    @PostMapping
    public ResponseEntity<Consulta> criaConsulta(@RequestBody Consulta consulta){
        consultaService.create(consulta);
        Cliente cliente = clienteService.read(consulta.getPet().getClientId());
        int dia = consulta.getData().getDayOfMonth(), mes = consulta.getData().getMonthValue(), ano = consulta.getData().getYear();
        int hora = consulta.getData().getHour(), minutos = consulta.getData().getMinute();
        emailService.agendaEmailTexto(cliente.getEmail(), "Consulta Marcada",
                String.format("Olá %s!\nSua consulta está marcada para %d/%d/%d as %d:%d!\n", cliente.getName(), dia, mes, ano, hora, minutos), consulta.getData());
        return ResponseEntity.status(HttpStatus.CREATED).body(consulta);
    }
}

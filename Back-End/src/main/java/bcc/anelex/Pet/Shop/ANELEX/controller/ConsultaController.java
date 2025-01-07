package bcc.anelex.Pet.Shop.ANELEX.controller;


import bcc.anelex.Pet.Shop.ANELEX.model.entities.Consulta;
import bcc.anelex.Pet.Shop.ANELEX.model.services.ConsultaService;
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

    @GetMapping
    public ResponseEntity<List<Consulta>> pegarConsulta(){
        return ResponseEntity.status(HttpStatus.OK).body(this.consultaService.read());
    }

    @PostMapping
    public ResponseEntity<Consulta> criaConsulta(@RequestBody Consulta consulta){
        this.consultaService.create(consulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(consulta);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizaConsulta(@PathVariable Long id, @RequestBody Consulta consulta){
        Consulta consultaOriginal = this.consultaService.update(id, consulta);
        return new ResponseEntity(consultaOriginal, HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Consulta> deletaConsulta(@PathVariable Long id){
        this.consultaService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

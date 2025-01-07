package bcc.anelex.Pet.Shop.ANELEX.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("relatorioConsultas")
public class RelatorioConsultasController {
    @Autowired
    private RelatorioConsultasService relatorioConsultasService;

    @GetMapping
    public ResponseEntity<List<RelatorioConsultas>> pegaRelatorios(){
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioConsultasService.read());
    }

    @GetMapping("{id}")
    public ResponseEntity<RelatorioVendas> pegaRelatorio(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioConsultasService.read(id));
    }

    @PostMapping
    public ResponseEntity<RelatorioVendas> salvaRelatorios(@RequestBody RelatorioConsultas relatorioConsultas){
        this.relatorioConsultasService.create(relatorioConsultas);
        return ResponseEntity.status(HttpStatus.CREATED).body(relatorioConsultas);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizaRelatorio(@PathVariable Long id, @RequestBody RelatorioConsultas relatorioConsultas){
        RelatorioConsultas relatorioConsultasOriginal = this.relatorioConsultasService.update(id, relatorioConsultas);
        return new ResponseEntity(relatorioConsultasOriginal, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<RelatorioConsultas> deletaRelatorio(@PathVariable Long id){
        this.relatorioConsultasService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
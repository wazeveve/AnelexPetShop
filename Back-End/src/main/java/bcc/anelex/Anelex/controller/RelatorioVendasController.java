package bcc.anelex.Anelex.controller;

import bcc.anelex.Anelex.model.entities.RelatorioVendas;
import bcc.anelex.Anelex.model.services.RelatorioVendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("relatorioVendas")
public class RelatorioVendasController {
    @Autowired
    private RelatorioVendasService relatorioVendasService;

    @GetMapping
    public ResponseEntity<List<RelatorioVendas>> pegaRelatorios(){
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioVendasService.read());
    }

    @GetMapping("{id}")
    public ResponseEntity<RelatorioVendas> pegaRelatorio(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioVendasService.read(id));
    }

    @PostMapping
    public ResponseEntity<RelatorioVendas> salvaRelatorios(@RequestBody RelatorioVendas relatorioVendas){
        this.relatorioVendasService.create(relatorioVendas);
        return ResponseEntity.status(HttpStatus.CREATED).body(relatorioVendas);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizaRelatorio(@PathVariable Long id, @RequestBody RelatorioVendas relatorioVendas){
        RelatorioVendas relatorioVendasOriginal = this.relatorioVendasService.update(id, relatorioVendas);
        return new ResponseEntity(relatorioVendasOriginal, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<RelatorioVendas> deletaRelatorio(@PathVariable Long id){
        this.relatorioVendasService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
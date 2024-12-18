package bcc.anelex.Pet.Shop.ANELEX.controller;

import bcc.anelex.Pet.Shop.ANELEX.model.entities.RelatorioVendas;
import bcc.anelex.Pet.Shop.ANELEX.model.repositories.RelatorioVendasRepository;
import bcc.anelex.Pet.Shop.ANELEX.model.services.RelatorioVendasService;
import org.apache.coyote.Response;
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
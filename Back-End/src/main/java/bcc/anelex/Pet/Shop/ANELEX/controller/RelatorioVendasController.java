package bcc.anelex.Pet.Shop.ANELEX.controller;

import bcc.anelex.Pet.Shop.ANELEX.model.entities.RelatorioVendas;
import bcc.anelex.Pet.Shop.ANELEX.model.repositories.RelatorioVendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("relatorioVendas")
public class RelatorioVendasController {
    @Autowired
    RelatorioVendasRepository relatorioVendasRepository;

    @GetMapping
    public ResponseEntity<List<RelatorioVendas>> pegaRelatorios(){
        return ResponseEntity.ok(this.relatorioVendasRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<RelatorioVendas> salvaRelatorios(@RequestBody RelatorioVendas relatorioVendas){
        this.relatorioVendasRepository.save(relatorioVendas);
        return ResponseEntity.status(HttpStatus.CREATED).body(relatorioVendas);
    }
}
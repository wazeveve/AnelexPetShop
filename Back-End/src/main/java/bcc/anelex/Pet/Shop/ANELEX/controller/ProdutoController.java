package bcc.anelex.Pet.Shop.ANELEX.controller;

import bcc.anelex.Pet.Shop.ANELEX.model.entities.Produto;
import bcc.anelex.Pet.Shop.ANELEX.model.exceptions.ProdutoNotFoundException;
import bcc.anelex.Pet.Shop.ANELEX.model.repositories.ProdutoRepository;
import bcc.anelex.Pet.Shop.ANELEX.model.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> pegaProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.read());
    }

    @PostMapping
    public ResponseEntity<Produto> criaProduto(@RequestBody Produto produto){
        this.produtoService.create(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizaProduto(@PathVariable Long id, @RequestBody Produto produto){
        try{
            Produto produtoOriginal = this.produtoService.update(id, produto);
            return new ResponseEntity(produtoOriginal, HttpStatus.OK);
        } catch (ProdutoNotFoundException pnfe) {
            return new ResponseEntity(pnfe.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Produto> deletaProduto(@PathVariable Long id){
        try{
            this.produtoService.delete(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (ProdutoNotFoundException pnfe){
            return new ResponseEntity(pnfe.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

package bcc.anelex.Anelex.controller;

import bcc.anelex.Anelex.model.entities.Produto;
import bcc.anelex.Anelex.model.services.ProdutoService;
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
    public ResponseEntity<List<Produto>> pegaProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.read());
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> pegaProduto(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.read(id));
    }

    @PostMapping
    public ResponseEntity<Produto> criaProduto(@RequestBody Produto produto) {
        this.produtoService.create(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizaProduto(@PathVariable Long id, @RequestBody Produto produto) {
        Produto produtoOriginal = this.produtoService.update(id, produto);
        return new ResponseEntity(produtoOriginal, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Produto> deletaProduto(@PathVariable Long id) {
        this.produtoService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

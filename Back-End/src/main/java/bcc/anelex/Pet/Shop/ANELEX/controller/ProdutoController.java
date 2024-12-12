package bcc.anelex.Pet.Shop.ANELEX.controller;

import bcc.anelex.Pet.Shop.ANELEX.model.entities.Produto;
import bcc.anelex.Pet.Shop.ANELEX.model.repositories.ProdutoRepository;
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
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> pegaProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Produto> criaProduto(@RequestBody Produto produto){
        this.produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Produto> atualizaProduto(@PathVariable Long id, @RequestBody Produto produto){
        Optional<Produto> optional = this.produtoRepository.findById(id);
        if(optional.isPresent()){
            Produto produtoN = (Produto) optional.get();
            produtoN.setName(produto.getName());
            produtoN.setDescription(produto.getDescription());
            produtoN.setPath(produto.getPath());
            produtoN.setValue(produto.getValue());
            this.produtoRepository.save(produtoN);
            return ResponseEntity.status(HttpStatus.CREATED).body(produtoN);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Produto());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Produto> deletaProduto(@PathVariable Long id){
        Optional<Produto> optional = this.produtoRepository.findById(id);
        if(optional.isPresent()){
            Produto produtoD = (Produto) optional.get();
            this.produtoRepository.delete(produtoD);
            return ResponseEntity.status(HttpStatus.OK).body(produtoD);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Produto());
        }
    }
}

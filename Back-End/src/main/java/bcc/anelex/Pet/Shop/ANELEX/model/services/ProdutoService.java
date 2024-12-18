package bcc.anelex.Pet.Shop.ANELEX.model.services;


import bcc.anelex.Pet.Shop.ANELEX.model.entities.Produto;
import bcc.anelex.Pet.Shop.ANELEX.model.exceptions.GerenteNotFoundException;
import bcc.anelex.Pet.Shop.ANELEX.model.exceptions.ProdutoNotFoundException;
import bcc.anelex.Pet.Shop.ANELEX.model.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto create(Produto produto) {
        this.produtoRepository.save(produto);
        return produto;
    }

    public Produto read(Long id) {
        Optional opt = this.produtoRepository.findById(id);
        if (!opt.isPresent()) {
            throw new ProdutoNotFoundException(id);
        }
        return (Produto) opt.get();
    }

    public List<Produto> read() {
        return this.produtoRepository.findAll();
    }

    public Produto update(Long id, Produto produto) throws ProdutoNotFoundException {
        Produto produtoOriginal = read(id);
        produtoOriginal.setName(produto.getName());
        produtoOriginal.setDescription(produto.getDescription());
        produtoOriginal.setValue(produto.getValue());
        produtoOriginal.setPath(produto.getPath());
        this.produtoRepository.save(produtoOriginal);
        return produtoOriginal;
    }

    public void delete(@PathVariable Long id) throws ProdutoNotFoundException {
        if (!this.produtoRepository.existsById(id)) {
            throw new ProdutoNotFoundException(id);
        }
        this.produtoRepository.deleteById(id);
    }
}
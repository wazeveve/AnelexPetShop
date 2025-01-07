package bcc.anelex.Pet.Shop.ANELEX.model.entities;

import bcc.anelex.Anelex.model.entities.Cliente;
import bcc.anelex.Anelex.model.entities.Produto;
import jakarta.persistence.*;

import java.util.Set;

public class RelatorioConsultas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private bcc.anelex.Anelex.model.entities.Cliente cliente;
    @OneToMany
    @JoinColumn(name = "produto_id")
    private Set<bcc.anelex.Anelex.model.entities.Produto> produtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public bcc.anelex.Anelex.model.entities.Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<bcc.anelex.Anelex.model.entities.Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}

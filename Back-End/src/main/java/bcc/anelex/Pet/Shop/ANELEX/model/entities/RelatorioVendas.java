package bcc.anelex.Pet.Shop.ANELEX.model.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class RelatorioVendas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Cliente cliente;
    @OneToMany
    @JoinColumn(name = "produto_id")
    private Set<Produto> produtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}

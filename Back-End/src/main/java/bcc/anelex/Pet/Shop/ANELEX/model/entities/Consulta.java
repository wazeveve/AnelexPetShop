package bcc.anelex.Pet.Shop.ANELEX.model.entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "data", nullable = false)
    private Date data;
    @Column(name = "clienteNome", nullable = false, length = 100)
    private String clienteNome;
    @Column(name = "petNome", nullable = false, length = 50)
    private String petNome;
    @Column(name = "valorConsulta", nullable = false)
    private float valorConsulta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getPetNome() {
        return petNome;
    }

    public void setPetNome(String petNome) {
        this.petNome = petNome;
    }

    public float getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(float valorConsulta) {
        this.valorConsulta = valorConsulta;
    }
}

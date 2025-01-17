package bcc.anelex.Anelex.model.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Consulta {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "data", nullable = false)
    private LocalDateTime data;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "petId", referencedColumnName = "id")
    private Pet pet;
    @Column(name = "valorConsulta", nullable = false)
    private float valorConsulta;

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Pet getPet() { return pet; }

    public void setPet(Pet pet) { this.pet = pet; }

    public float getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(float valorConsulta) {
        this.valorConsulta = valorConsulta;
    }
}
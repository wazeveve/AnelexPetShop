package bcc.anelex.Anelex.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Pet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String description;
    @Column(length = 50, nullable = false)
    private String gender;
    @Column(nullable = false)
    private Date age;
    @Column(nullable = false, length = 100)
    private String tipo;
    @Column(length = 150, nullable = false)
    private String path;
    @OneToOne(mappedBy = "pet")
    private Consulta consulta;
    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Cliente client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getClientId() { return client.getId(); }

    public void setClient(Cliente client) { this.client = client; }

    public Consulta getConsulta() { return consulta; }

    public void setConsulta(Consulta consulta) { this.consulta = consulta; }
}
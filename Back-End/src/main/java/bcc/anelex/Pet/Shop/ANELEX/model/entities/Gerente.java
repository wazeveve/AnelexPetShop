package bcc.anelex.Pet.Shop.ANELEX.model.entities;

import jakarta.persistence.*;

@Entity
public class Gerente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "cpf", nullable = false, length = 20)
    private String cpf;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "telephone", length = 25)
    private String telephone;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

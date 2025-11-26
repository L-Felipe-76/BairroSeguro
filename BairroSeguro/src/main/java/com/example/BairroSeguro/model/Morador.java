package com.example.BairroSeguro.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.sql.Date;

@Entity
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 250)
    @Check(name = "lenght_check", constraints = "LENGTH(morador.full_name) > 7")
    private String fullName;
    @Enumerated(EnumType.STRING)
    private User.Genero genre;
    @Column(nullable = false)
    private Date aniversary; // Adicionar mascara dd/mm/yyyy no front
    @Column(nullable = false, length = 15)
    private String phone; // Adicionar mascara (xx) xxxxx-xxxx no front

    //Relacionamentos
    @ManyToOne
    private User usersMoradores;

    //Construtores

    public Morador() {
    }

    public Morador(Long id, String fullName, User.Genero genre, Date aniversary, String phone, User user) {
        this.id = id;
        this.fullName = fullName;
        this.genre = genre;
        this.aniversary = aniversary;
        this.phone = phone;
        this.usersMoradores = user;
    }

    //Gets & Sets

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public User.Genero getGenre() {
        return genre;
    }

    public void setGenre(User.Genero genre) {
        this.genre = genre;
    }

    public Date getAniversary() {
        return aniversary;
    }

    public void setAniversary(Date aniversary) {
        this.aniversary = aniversary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return usersMoradores;
    }

    public void setUser(User user) {
        this.usersMoradores = user;
    }
}

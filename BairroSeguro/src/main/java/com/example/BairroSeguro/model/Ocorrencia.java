package com.example.BairroSeguro.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;
import java.sql.Timestamp;

@Entity
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 250)
    @Check(name = "lenght_check", constraints = "LENGTH(titulo) > 5")
    private String titulo; //Add hint no front
    @Column(nullable = false, length = 250)
    @Check(name = "lenght_check2", constraints = "LENGTH(descricao) > 50")
    private String descricao; //Add hint no front
    @Enumerated(EnumType.STRING)
    private tags tag;
    @Column(nullable = false)
    @Check(name = "time_check", constraints = "data_Hora = NOW()")
    private Timestamp data_Hora;

    //Enum para tag
    public enum tags{
        CRIMINAL,
        INFRAESTRUTURAL,
        AJUDA_ESPECIALIZADA
    }

    //Relacionamentos
    @ManyToOne
    private User usersOcorrencia;

    @ManyToOne
    private Endereco enderecos;

    //Construtores

    public Ocorrencia() {
    }

    public Ocorrencia(Long id, String titulo, String descricao, tags tag, Timestamp data_Hora, User user, Endereco enderecos) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tag = tag;
        this.data_Hora = data_Hora;
        this.usersOcorrencia = user;
        this.enderecos = enderecos;
    }

    //Gets & Sets

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public tags getTag() {
        return tag;
    }

    public void setTag(tags tag) {
        this.tag = tag;
    }

    public Timestamp getData_Hora() {
        return data_Hora;
    }

    public void setData_Hora(Timestamp data_Hora) {
        this.data_Hora = data_Hora;
    }

    public User getUser() {
        return usersOcorrencia;
    }

    public void setUser(User user) {
        this.usersOcorrencia = user;
    }

    public Endereco getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco enderecos) {
        this.enderecos = enderecos;
    }
}

package com.example.BairroSeguro.model;

import jakarta.persistence.*;
import java.util.List;


@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 9)
    private String cep;
    @Column(nullable = false, length = 250)
    private String estado;
    @Column(nullable = false, length = 250)
    private String cidade;
    @Column(nullable = false, length = 250)
    private String bairro;
    @Column(nullable = false, length = 250)
    private String rua;
    @Column(nullable = false, length = 5)
    private String numeroCasa;
    @Column(nullable = false, length = 2000)
    private String referenciasRua;

    //Relacionamentos
    @OneToOne
    private User usersEnderecos;

    @OneToMany(mappedBy = "enderecos", cascade = CascadeType.ALL)
    private List<Ocorrencia> ocorrencia;

    //Construtores

    public Endereco() {
    }

    public Endereco(Long id, String cep, String estado, String cidade, String bairro, String rua, String numeroCasa, String referenciasRua, User user, List<Ocorrencia> ocorrencia) {
        this.id = id;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.referenciasRua = referenciasRua;
        this.usersEnderecos = user;
        this.ocorrencia = ocorrencia;
    }

    //Gets & Sets

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getReferenciasRua() {
        return referenciasRua;
    }

    public void setReferenciasRua(String referenciasRua) {
        this.referenciasRua = referenciasRua;
    }

    public User getUser() {
        return usersEnderecos;
    }

    public void setUser(User user) {
        this.usersEnderecos = user;
    }

    public List<Ocorrencia> getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(List<Ocorrencia> ocorrencia) {
        this.ocorrencia = ocorrencia;
    }
}

package com.example.BairroSeguro.model;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;
import java.sql.Date;
import java.util.List;
@Entity
@Table(name = "users")
public class User {

    //Colunas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 250)
    @Check(name = "lenght_check", constraints = "LENGTH(full_name) > 7")
    private String fullName;
    @Enumerated(EnumType.STRING)
    private Genero genre;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Date aniversary; // Adicionar mascara dd/mm/yyyy no front
    @Column(nullable = false)
    @Check(name = "password_check", constraints = "password = confirm_password")
    private String password; // Adicionar mascara de substituição ******** no front
    @Column(nullable = false)
    @Check(name = "password_check", constraints = "password = confirm_password")
    private String confirmPassword; // Adicionar mascara de substituição ******** no front
    @Column(nullable = false, length = 15)
    private String phone; // Adicionar mascara (xx) xxxxx-xxxx no front
    @Column(nullable = false)
    @Check(name = "qt_moradores_check", constraints = "qt_moradores >= 0 AND qt_moradores <= 10")
    private Integer qtMoradores;

    //Enum para genre
    public enum Genero{
        MASCULINO,
        FEMININO,
        PREFIRO_NAO_INFORMAR
    }

    //Trigger para email
    //Não entendi como fazer no jpa, decidi fazer direto no banco.

    //Relacionamento
    @OneToMany(mappedBy = "usersMoradores", cascade = CascadeType.ALL)
    private List<Morador> morador;
    @OneToMany(mappedBy = "usersOcorrencia", cascade = CascadeType.ALL)
    private List<Ocorrencia> ocorrencia;
    @OneToOne(mappedBy = "usersEnderecos")
    private Endereco enderecos;

    //Construtores

    public User() {
    }

    public User(Long id, String fullName, Genero genre, String email, Date aniversary, String password, String confirmPassword, String phone, Integer qtMoradores, List<Morador> morador, List<Ocorrencia> ocorrencia, Endereco enderecos) {
        this.id = id;
        this.fullName = fullName;
        this.genre = genre;
        this.email = email;
        this.aniversary = aniversary;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.phone = phone;
        this.qtMoradores = qtMoradores;
        this.morador = morador;
        this.ocorrencia = ocorrencia;
        this.enderecos = enderecos;
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

    public Genero getGenre() {
        return genre;
    }

    public void setGenre(Genero genre) {
        this.genre = genre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAniversary() {
        return aniversary;
    }

    public void setAniversary(Date aniversary) {
        this.aniversary = aniversary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getQtMoradores() {
        return qtMoradores;
    }

    public void setQtMoradores(Integer qtMoradores) {
        this.qtMoradores = qtMoradores;
    }

    public List<Morador> getMorador() {
        return morador;
    }

    public void setMorador(List<Morador> morador) {
        this.morador = morador;
    }

    public List<Ocorrencia> getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(List<Ocorrencia> ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public Endereco getEndereco() {
        return enderecos;
    }

    public void setEndereco(Endereco endereco) {
        this.enderecos = endereco;
    }
}

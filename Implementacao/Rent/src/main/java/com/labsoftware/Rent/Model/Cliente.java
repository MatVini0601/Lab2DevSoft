package com.labsoftware.Rent.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = Cliente.TABLE_NAME)
public class Cliente {
    public static final String TABLE_NAME = "cliente";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idcliente")
    private Integer id;

    @NotNull
    @Column(name = "cpfcliente", length = 14, nullable = false)
    private String cpf;

    @NotNull
    @Column(name = "rgcliente", length = 8, nullable = false)
    private String rg;

    @NotNull
    @Column(name = "nomecliente", length = 50, nullable = false)
    private String nome;

    @NotNull
    @Column(name = "enderecocliente", length = 200, nullable = false)
    private String endereco;

    @NotNull
    @Column(name = "profissaocliente", length = 100, nullable = false)
    private String profissao;

    @OneToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    private Usuario usuario;


    public Cliente(){}

    public Cliente(Integer id, String cpf, String rg, String nome, String endereco, String profissao){
        this.id = id;
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.endereco = endereco;
        this.profissao = profissao;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setRg(String rg){
        this.rg = rg;
    }

    public String getRg(){
        return this.rg;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setProfissao(String profissao){
        this.profissao = profissao;
    }

    public String getProfissao(){
        return this.profissao;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public Usuario getUsuario(){
        return this.usuario;
    }

    public Integer getUserId(){
        return this.usuario.getId();
    }
}
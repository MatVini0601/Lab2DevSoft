package com.labsoftware.Rent.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = Pedido.TABLE_NAME)
public class Pedido {
    public static final String TABLE_NAME = "pedido";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "agente_id", nullable = true)
    private Usuario agente;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFim;

    @Column(nullable = false)
    private Integer duracaoMeses; // 12, 24, 36, 48 meses

    @Column(nullable = false)
    private boolean opcaoCompra;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    // Construtores, getters e setters
    public Pedido() {}

    public Pedido(Cliente cliente, Integer duracaoMeses, boolean opcaoCompra, Veiculo veiculo) {
        this.cliente = cliente;
        this.dataInicio = LocalDate.now();
        this.duracaoMeses = duracaoMeses;
        this.opcaoCompra = opcaoCompra;
        this.veiculo = veiculo;
        this.status = false;
        this.dataFim = dataInicio.plusMonths(duracaoMeses);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setAgente(Usuario agente) {
        this.agente = agente;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public void setDuracaoMeses(Integer duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
    }

    public void setOpcaoCompra(boolean opcaoCompra) {
        this.opcaoCompra = opcaoCompra;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public boolean getOpcaoCompra() {
        return opcaoCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Usuario getAgente() {
        return agente;
    }

    public Boolean getStatus() {
        return status;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public Integer getDuracaoMeses() {
        return duracaoMeses;
    }

    public boolean isOpcaoCompra() {
        return opcaoCompra;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
}



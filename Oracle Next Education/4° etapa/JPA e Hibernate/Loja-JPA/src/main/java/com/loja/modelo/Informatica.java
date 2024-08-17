package com.loja.modelo;


import jakarta.persistence.Entity;

@Entity
public class Informatica extends Produto{
    private String marca;
    private String modelo;
    private String processador;
    private String memoria;
    private String hd;

    public Informatica() {
    }

    public Informatica(String marca, String modelo, String processador, String memoria, String hd) {
        this.marca = marca;
        this.modelo = modelo;
        this.processador = processador;
        this.memoria = memoria;
        this.hd = hd;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }
}

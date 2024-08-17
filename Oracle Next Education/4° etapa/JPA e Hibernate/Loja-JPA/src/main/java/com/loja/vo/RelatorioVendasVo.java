package com.loja.vo;

import java.time.LocalDate;

public class RelatorioVendasVo {
    private String nomeProduto;
    private Long quantidade;
    private LocalDate dataUltimaVenda;

    public RelatorioVendasVo(String nomeProduto, Long quantidade, LocalDate dataUltimaVenda) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.dataUltimaVenda = dataUltimaVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public LocalDate getDataUltimaVenda() {
        return dataUltimaVenda;
    }

    @Override
    public String toString() {
        return "[nomeProduto= " + nomeProduto + ", quantidade= " + quantidade + ", dataUltimaVenda= " + dataUltimaVenda + "]";
    }
}

package com.loja.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "preco_produto")
    private BigDecimal precoProduto;

    private Integer quantidade;

    @ManyToOne
    private Pedidos pedido;

    @ManyToOne
    private Produto produto;

    public ItemPedido() {
    }
    public ItemPedido(Integer quantidade, Pedidos pedido, Produto produto) {
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.precoProduto = produto.getPreco();
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(BigDecimal precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getValorTotal() {
        return precoProduto.multiply(new BigDecimal(quantidade));
    }
}

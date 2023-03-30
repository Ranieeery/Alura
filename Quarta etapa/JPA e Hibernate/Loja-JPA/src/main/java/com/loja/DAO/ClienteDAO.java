package com.loja.DAO;

import com.loja.modelo.Pedidos;
import com.loja.modelo.Produto;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {
    private EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastro(Pedidos pedidos) {
        this.em.persist(pedidos);
    }

    public void atualizar(Pedidos pedidos) {
        this.em.merge(pedidos);
    }

}

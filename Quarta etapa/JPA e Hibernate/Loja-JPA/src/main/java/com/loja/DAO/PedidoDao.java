package com.loja.DAO;

import com.loja.modelo.Pedidos;
import com.loja.vo.RelatorioVendasVo;
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

    public BigDecimal valorTotalVendido() {
        String jpql = "select sum(p.valorTotal) from Pedidos p";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public List<RelatorioVendasVo> relatorioVendas() {
        String jpql = "select new com.loja.vo.RelatorioVendasVo("
                + "p.produto.nome, "
                + "sum(p.quantidade), "
                + "max(p.pedido.dataCadastro)) "
                + "from ItemPedido p "
                + "group by p.produto.nome "
                + "order by sum(p.quantidade) desc";
        return em.createQuery(jpql, RelatorioVendasVo.class).getResultList();
    }
}

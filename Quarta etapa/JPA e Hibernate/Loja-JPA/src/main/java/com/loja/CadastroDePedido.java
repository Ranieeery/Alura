package com.loja;

import com.loja.DAO.CategoriaDao;
import com.loja.DAO.ClienteDAO;
import com.loja.DAO.PedidoDao;
import com.loja.DAO.ProdutoDao;
import com.loja.modelo.*;
import com.loja.util.JPAUtil;
import com.loja.vo.RelatorioVendasVo;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class CadastroDePedido {

    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        Produto produto = produtoDao.buscaId(1L);
        Produto produto2 = produtoDao.buscaId(2L);
        Produto produto3 = produtoDao.buscaId(3L);
        Cliente cliente = clienteDAO.buscaId(1L);

        em.getTransaction().begin();

        Pedidos pedido = new Pedidos(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, produto));
        pedido.adicionarItem(new ItemPedido(20, pedido, produto2));

        Pedidos pedido2 = new Pedidos(cliente);
        pedido2.adicionarItem(new ItemPedido(2, pedido2, produto3));

        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastro(pedido);
        pedidoDao.cadastro(pedido2);

        em.getTransaction().commit();

        BigDecimal totalVendido = new PedidoDao(em).valorTotalVendido();
        System.out.println("Valor total vendido: " + totalVendido);

        List<RelatorioVendasVo> relatorio = pedidoDao.relatorioVendas();
        relatorio.forEach(System.out::println);

        em.close();

    }
    public static void cadastrarProduto() {
        Categoria moveis = new Categoria("Móveis");
        Categoria vestuario = new Categoria("Vestuário");
        Categoria eletronicos = new Categoria("Eletrônicos");

        Produto produto = new Produto("Mesa gamer", "Mesa com suporte e ajuste de altura", BigDecimal.valueOf(799.0), moveis);
        Produto produto2 = new Produto("Cadeira gamer", "Cadeira com suporte e ajuste de altura", BigDecimal.valueOf(499.0), moveis);
        Produto produto3 = new Produto("Camiseta", "Camiseta branca", BigDecimal.valueOf(49.0), vestuario);
        Produto produto4 = new Produto("Notebook", "Notebook com 8GB de RAM", BigDecimal.valueOf(2999.0), eletronicos);

        Cliente cliente = new Cliente("João", "123.456.789-00");

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        em.getTransaction().begin();

        categoriaDao.cadastro(moveis);
        categoriaDao.cadastro(vestuario);
        categoriaDao.cadastro(eletronicos);

        produtoDao.cadastro(produto);
        produtoDao.cadastro(produto2);
        produtoDao.cadastro(produto3);
        produtoDao.cadastro(produto4);

        clienteDAO.cadastro(cliente);

        em.getTransaction().commit();
        em.close();
    }
}

package com.loja;

import com.loja.DAO.CategoriaDao;
import com.loja.DAO.ClienteDAO;
import com.loja.DAO.PedidoDao;
import com.loja.DAO.ProdutoDao;
import com.loja.modelo.Categoria;
import com.loja.modelo.Cliente;
import com.loja.modelo.Pedidos;
import com.loja.modelo.Produto;
import com.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class PerformanceConsulta {

    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        PedidoDao pedidoDao = new PedidoDao(em);
        Pedidos pedido = pedidoDao.buscarPedidoComCliente(1L);

        em.close();
        System.out.println(pedido.getCliente().getNome());
    }


    public static void cadastrarProduto() {
        Categoria moveis = new Categoria("Móveis diversos");
        Categoria roupas = new Categoria("Roupas");
        Categoria equipamentos = new Categoria("Equipamentos");

        Produto produto = new Produto("Mesa", "Mesa com suporte e ajuste de altura", BigDecimal.valueOf(799.0), moveis);
        Produto produto2 = new Produto("Cadeira", "Cadeira com suporte e ajuste de altura", BigDecimal.valueOf(499.0), moveis);
        Produto produto3 = new Produto("Camiseta", "Camiseta verde", BigDecimal.valueOf(49.0), roupas);
        Produto produto4 = new Produto("Notebook Positivo", "Notebook com 1GB de RAM", BigDecimal.valueOf(2999.0), equipamentos);

        Cliente cliente = new Cliente("Carlos", "123.456.789-00");

        EntityManager manager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(manager);
        CategoriaDao categoriaDao = new CategoriaDao(manager);
        ClienteDAO clienteDAO = new ClienteDAO(manager);

        manager.getTransaction().begin();

        categoriaDao.cadastro(moveis);
        categoriaDao.cadastro(roupas);
        categoriaDao.cadastro(equipamentos);

        produtoDao.cadastro(produto);
        produtoDao.cadastro(produto2);
        produtoDao.cadastro(produto3);
        produtoDao.cadastro(produto4);

        clienteDAO.cadastro(cliente);

        manager.getTransaction().commit();

        manager.close();
    }
}

package com.loja;

import com.loja.DAO.CategoriaDao;
import com.loja.DAO.ProdutoDao;
import com.loja.modelo.Categoria;
import com.loja.modelo.Produto;
import com.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class CadastroDeProdutos {

    public static void main(String[] args) {
        cadastroProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        System.out.println("Buscando um preço pelo ID: " + produtoDao.buscaId(1L).getPreco());
        produtoDao.buscarTodos().forEach(p -> System.out.println(p.getId() + " - " + p.getNome()));

        produtoDao.buscarPorNome("MagaReader").forEach(p -> System.out.println(p.getId() + " - " + p.getNome()));

        produtoDao.buscarPorCategoria("Informática").forEach(p -> System.out.println(p.getId() + " - " + p.getNome()));
    }
    public static void cadastroProduto() {
        Categoria informatica = new Categoria("Informática");
        Produto produto = new Produto("Kindle", "E-reader da Amazon", BigDecimal.valueOf(599.0), informatica);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastro(informatica);
        produtoDao.cadastro(produto);

        em.getTransaction().commit();
        em.close();
    }
}
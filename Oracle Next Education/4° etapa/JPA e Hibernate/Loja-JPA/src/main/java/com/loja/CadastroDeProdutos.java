package com.loja;

import com.loja.DAO.CategoriaDao;
import com.loja.DAO.ProdutoDao;
import com.loja.modelo.Categoria;
import com.loja.modelo.Produto;
import com.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProdutos {

    public static void main(String[] args) {
        cadastroProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto produto = produtoDao.buscaId(1L);
        System.out.println("Preço do produto: " + produto.getPreco());

        List<Produto> precoComNome = produtoDao.buscarPorCategoria("Informática");
        precoComNome.forEach(p -> System.out.println(p.getId() + " - " + p.getNome()));

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
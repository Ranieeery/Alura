package com.loja;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.loja.modelo.Produto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CadastroDeProdutosTest {

    private EntityManagerFactory emf;
    private EntityManager em;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("loja");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void testInserirProduto() {
        Produto produto = new Produto();
        produto.setNome("S20");
        produto.setDescricao("Smartphone da Samsung");
        produto.setPreco(BigDecimal.valueOf(5599.0));

        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();

        Produto produtoPersistido = em.find(Produto.class, produto.getId());

        assertEquals("Kindle", produtoPersistido.getNome());
        assertEquals("E-reader da Amazon", produtoPersistido.getDescricao());
        assertEquals(BigDecimal.valueOf(599.0), produtoPersistido.getPreco());
    }

    @Test
    public void testInserirOutroProduto() {
        Produto produto = new Produto();
        produto.setNome("iPhone");
        produto.setDescricao("Aifon da Apple");
        produto.setPreco(BigDecimal.valueOf(6999.0));

        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();

        Produto produtoPersistido = em.find(Produto.class, produto.getId());

        assertEquals("iPhone", produtoPersistido.getNome());
        assertEquals("Smartphone da Apple", produtoPersistido.getDescricao());
        assertEquals(BigDecimal.valueOf(6999.0), produtoPersistido.getPreco());
    }

    // Adicionar mais testes para inserir outros produtos

}

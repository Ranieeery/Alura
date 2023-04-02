package com.loja.DAO;

import com.loja.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastro(Produto produto) {
        this.em.persist(produto);
    }

    public void atualizar(Produto produto) {
        this.em.merge(produto);
    }

    public void remover(Produto produto) {
        produto = em.merge(produto);
        this.em.remove(produto);
    }

    public Produto buscaId(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome) {
        return em.createNamedQuery("Produto.listar", Produto.class).setParameter("nomeCategoria", nome).getResultList();
    }

    public List<Produto> buscarPorCategoria(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
        return em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
    }

    public BigDecimal buscarPrecoComNome(String nome) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, BigDecimal.class).setParameter("nome", nome).getSingleResult();
    }

    public List<Produto> buscarPorParametro(String nome, BigDecimal preco, LocalDate dataCadastro) {
        String jpql = "select p from Produto p where 1=1";
        if (nome != null && !nome.trim().isEmpty()) {
            jpql += " and p.nome = :nome";
        }
        if (preco != null) {
            jpql += " and p.preco = :preco";
        }
        if (dataCadastro != null) {
            jpql += " and p.dataCadastro = :dataCadastro";
        }
        TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
        if (nome != null && !nome.trim().isEmpty()) {
            query.setParameter("nome", nome);
        }
        if (preco != null) {
            query.setParameter("preco", preco);
        }
        if (dataCadastro != null) {
            query.setParameter("dataCadastro", dataCadastro);
        }

        return query.getResultList();
    }

    public List<Produto> buscarPorParametroComCriteria(String nome, BigDecimal preco, LocalDate dataCadastro) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Produto> criteriaQuery = criteriaBuilder.createQuery(Produto.class);
        Root<Produto> root = criteriaQuery.from(Produto.class);
        Predicate predicate = criteriaBuilder.and();

        if (nome != null && !nome.trim().isEmpty()) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("nome"), nome));
        }
        if (preco != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("preco"), preco));
        }
        if (dataCadastro != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("dataCadastro"), dataCadastro));
        }

        criteriaQuery.where(predicate);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
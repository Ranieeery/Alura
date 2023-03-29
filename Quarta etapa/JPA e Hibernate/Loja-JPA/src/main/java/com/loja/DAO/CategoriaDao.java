package com.loja.DAO;

import com.loja.modelo.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDao {
    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastro(Categoria categoria) {
        this.em.persist(categoria);
    }
}


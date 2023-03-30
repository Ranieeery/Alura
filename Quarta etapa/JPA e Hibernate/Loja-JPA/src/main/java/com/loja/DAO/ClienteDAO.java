package com.loja.DAO;

import com.loja.modelo.Cliente;
import jakarta.persistence.EntityManager;

public class ClienteDAO {
    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastro(Cliente cliente) {
        this.em.persist(cliente);
    }

    public Cliente buscaId(Long id) {
        return em.find(Cliente.class, id);
    }
}

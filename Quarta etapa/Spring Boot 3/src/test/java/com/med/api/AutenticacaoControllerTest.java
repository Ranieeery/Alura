package com.med.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.med.api.controller.AutenticacaoController;

import org.junit.Test;
import org.junit.Before;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.med.api.domain.usuario.DadosAutenticacao;
import com.med.api.domain.usuario.Usuario;
import com.med.api.infra.security.DadosTokenJWT;
import com.med.api.infra.security.TokenService;

public class AutenticacaoControllerTest {

    private AutenticacaoController autenticacaoController;
    private AuthenticationManager authManager;
    private TokenService tokenService;

    @Before
    public void setUp() {
        authManager = mock(AuthenticationManager.class);
        tokenService = mock(TokenService.class);
        autenticacaoController = new AutenticacaoController(authManager, tokenService);
    }

    @Test
    public void testAutenticar() {
        DadosAutenticacao dadosAutenticacao = new DadosAutenticacao("user", "password");
        Usuario usuario = new Usuario("user", "password");
        UsernamePasswordAuthenticationToken tokenAuth = new UsernamePasswordAuthenticationToken(usuario.getLogin(), usuario.getSenha());
        when(authManager.authenticate(tokenAuth)).thenReturn(tokenAuth);
        when(tokenService.genToken(usuario)).thenReturn("token");

        ResponseEntity<DadosTokenJWT> response = autenticacaoController.autenticar(dadosAutenticacao);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("token", response.getBody().getToken());
    }
}
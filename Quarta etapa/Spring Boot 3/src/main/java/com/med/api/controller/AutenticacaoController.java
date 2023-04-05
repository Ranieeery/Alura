package com.med.api.controller;

import com.med.api.domain.usuario.Usuario;
import com.med.api.infra.security.DadosTokenJWT;
import jakarta.validation.Valid;

import com.med.api.infra.security.TokenService;

import com.med.api.domain.usuario.DadosAutenticacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity autenticar(@RequestBody @Valid DadosAutenticacao dados) {
        var tokenAuth = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = authManager.authenticate(tokenAuth);
        var tokenJWT = tokenService.genToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}

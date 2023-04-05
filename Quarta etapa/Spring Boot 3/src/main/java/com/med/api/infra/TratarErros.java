package com.med.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratarErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException e) {
        var erro = e.getFieldErrors();
        return ResponseEntity.badRequest().body(erro.stream().map(DadosValidacao::new).toList());
    }

    private record DadosValidacao (String campo, String mensagem) {
        public DadosValidacao (FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}

package com.contas.controllers;

import com.contas.entities.Empresa;
import com.contas.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.InputMismatchException;
import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    EmpresaService service;

    @GetMapping
    public List<Empresa> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Empresa getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public void save(@RequestBody Empresa empresa) {
        String cnpj = empresa.getCnpj();

        if(!EmpresaService.validaCNPJ(cnpj)) {
            throw new InputMismatchException("CNPJ inválido enviado");
        }
        service.save(empresa);
    }
}

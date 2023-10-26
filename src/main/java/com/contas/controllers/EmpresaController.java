package com.contas.controllers;

import com.contas.entities.Empresa;
import com.contas.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    EmpresaService service;

    @GetMapping("/{id}")
    public Empresa getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Empresa empresa) {
        service.save(empresa);
        return new ResponseEntity<>(
                "Empresa adicionada com sucesso", null, HttpStatus.OK);
    }
}

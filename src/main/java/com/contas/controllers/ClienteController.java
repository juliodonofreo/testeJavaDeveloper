package com.contas.controllers;

import com.contas.entities.Cliente;
import com.contas.entities.Empresa;
import com.contas.services.ClienteService;
import com.contas.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("/{id}")
    public Cliente getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Cliente cliente) {
        service.save(cliente);
        return new ResponseEntity<>(
                "Cliente adicionado com sucesso", null, HttpStatus.OK);
    }
}

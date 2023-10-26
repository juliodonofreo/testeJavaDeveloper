package com.contas.controllers;

import com.contas.entities.Cliente;
import com.contas.entities.Empresa;
import com.contas.services.ClienteService;
import com.contas.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.InputMismatchException;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping
    public List<Cliente> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Cliente getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public void save(@RequestBody Cliente cliente) {
        String cpf = cliente.getCpf();
        if(!ClienteService.validaCPF(cpf)){
            throw new InputMismatchException("Cpf inválido enviado");
        }
        service.save(cliente);
    }
}

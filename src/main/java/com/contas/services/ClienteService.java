package com.contas.services;

import com.contas.entities.Cliente;
import com.contas.entities.Empresa;
import com.contas.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    /**
     * Encontra um cliente no banco de dados via id
     * através do repository de clientes
     * @param id   id do cliente a ser localizado
     * */
    public Cliente getById(Long id) {
        return repository.findById(id).get();
    }

    /**
     * Salva a entidade cliente recebida no banco de dados
     * através do repository de clientes
     * @param cliente   cliente a ser salvo no banco de dados
     */
    public void save(Cliente cliente) {
        repository.save(cliente);
    }
}

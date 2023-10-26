package com.contas.services;

import com.contas.entities.Empresa;
import com.contas.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository repository;

    /**
     * Encontra uma empresa no banco de dados via id
     * através do repository de empresas
     * @param id   id da empresa a ser localizada
     * */
    public Empresa getById(Long id) {
        return repository.findById(id).get();
    }

    /**
     * Salva a entidade empresa recebida no banco de dados
     * através do repository de empresas
     * @param empresa   empresa a ser salva no banco de ados
     * */
    public void save(Empresa empresa) {
        repository.save(empresa);
    }
}

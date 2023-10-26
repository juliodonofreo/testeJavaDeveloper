package com.contas.services;

import com.contas.entities.Empresa;
import com.contas.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository repository;

    /**
     * Retorna todos as empresas armazenadas na base de dados, o resultado vem como uma
     * lista de empresas
     */
    public List<Empresa> getAll() {
        return repository.findAll();
    }

    /**
     * Encontra uma empresa no banco de dados via id
     * através do repository de empresas
     *
     * @param id   id da empresa a ser localizada
     * */
    public Empresa getById(Long id) {
        return repository.findById(id).get();
    }

    /**
     * Salva a entidade empresa recebida no banco de dados
     * através do repository de empresas
     *
     * @param empresa   empresa a ser salva no banco de ados
     * */
    public void save(Empresa empresa) {
        repository.save(empresa);
    }

    /**
     * Este método estático possui a simples missão de validar um CNPJ
     * que já venha formatado com somente números, isto é feito através
     * do cálculo de validação de CNPJ.
     *
     * @param cnpj   CNPJ (FORMATADO) a ser validado
     */
    public static boolean validaCNPJ(String cnpj) {
        if (cnpj == null || !cnpj.matches("\\d{14}")) {
            return false;
        }

        int[] digitos = new int[14];
        for (int i = 0; i < 14; i++) {
            digitos[i] = cnpj.charAt(i) - '0';
        }

        int soma1 = 0;
        int soma2 = 0;
        int mod1, mod2;

        for (int i = 0, peso = 5; i < 12; i++) {
            soma1 += digitos[i] * peso;
            peso--;
            if (peso < 2) {
                peso = 9;
            }
        }

        mod1 = 11 - (soma1 % 11);
        if (mod1 >= 10) {
            mod1 = 0;
        }

        if (mod1 != digitos[12]) {
            return false;
        }

        for (int i = 0, peso = 6; i < 13; i++) {
            soma2 += digitos[i] * peso;
            peso--;
            if (peso < 2) {
                peso = 9;
            }
        }

        mod2 = 11 - (soma2 % 11);
        if (mod2 >= 10) {
            mod2 = 0;
        }

        return mod2 == digitos[13];
    }

}

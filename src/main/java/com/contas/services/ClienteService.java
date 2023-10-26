package com.contas.services;

import com.contas.entities.Cliente;
import com.contas.entities.Empresa;
import com.contas.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;

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
        System.out.println(ClienteService.validaCPF(repository.findById(id).get().getCpf()));
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

    /**
     * Este método estático possui a simples missão de validar um cpf
     * que já venha formatado com somente números, isto é feito através
     * do cálculo de validação de CPF.
     * @param cpf   CPF (FORMATADO) a ser validado
     */
    public static boolean validaCPF(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")) {
            return false;
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = cpf.charAt(i) - '0';
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 9; i++) {
            sum1 += digits[i] * (10 - i);
            sum2 += digits[i] * (11 - i);
        }

        int mod1 = (sum1 * 10) % 11;
        if (mod1 == 10) {
            mod1 = 0;
        }

        if (mod1 != digits[9]) {
            return false;
        }

        sum2 += mod1 * 2;
        int mod2 = (sum2 * 10) % 11;
        if (mod2 == 10) {
            mod2 = 0;
        }

        return mod2 == digits[10];
    }

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
            digito = Integer.parseInt(str.substring(indice,indice+1));
            soma += digito*peso[peso.length-str.length()+indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }
}

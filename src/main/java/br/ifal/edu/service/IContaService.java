package br.ifal.edu.service;

import br.ifal.edu.domain.Conta;

import java.util.List;

public interface IContaService {

    void save(Conta conta);

    void saque(String numero, Double valor);

    List<Conta> findAll();


}

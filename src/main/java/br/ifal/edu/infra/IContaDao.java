package br.ifal.edu.infra;

import br.ifal.edu.domain.Conta;

import java.util.List;

public interface IContaDao {

    void save(Conta conta);

    void saque(String numero, Double valor);

    List<Conta> findAll();
}

package br.ifal.edu.infra;

import br.ifal.edu.domain.Conta;

import java.util.ArrayList;
import java.util.List;

public class InMemoryContaDao implements IContaDao {

    private static List<Conta> db = new ArrayList<>();

    public void save(Conta conta) {
        // Chamada para o banco de dados
        db.add(conta);
    }

    @Override
    public void saque(String numero, Double valor) {
        System.out.println("Saque:  " + valor);
    }

    public List<Conta> findAll() {
        return db;
    }


}

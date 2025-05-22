package br.ifal.edu.infra;

import br.ifal.edu.domain.Conta;

import java.util.ArrayList;
import java.util.List;

public class MysqlContaDao implements IContaDao {
    private static List<Conta> db = new ArrayList<>();

    @Override
    public void save(Conta conta) {
        db.add(conta);
    }

    @Override
    public void saque(String numero, Double valor) {
        System.out.println("Saque:  " + valor);
    }

    @Override
    public List<Conta> findAll() {
        return db;
    }
}

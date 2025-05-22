package br.ifal.edu.service;

import br.ifal.edu.domain.Conta;
import br.ifal.edu.infra.IContaDao;

import java.util.List;

public class ContaService2 implements IContaService {

    private IContaDao dao;

    public ContaService2(IContaDao dao) {
        this.dao = dao;
    }

    public void save(Conta conta) {
        dao.save(conta);
    }

    @Override
    public void saque(String numero, Double valor) {

    }

    public List<Conta> findAll() {
        return dao.findAll();
    }

}

package br.ifal.edu.service;

import br.ifal.edu.domain.Conta;
import br.ifal.edu.infra.IContaDao;
import br.ifal.edu.infra.message.INotifier;
import br.ifal.edu.infra.message.Notifier;

import java.util.List;

public class ContaService implements IContaService {

    private IContaDao dao;
    private INotifier notifier;

    public ContaService(IContaDao dao, INotifier notifier) {
        this.dao = dao;
        this.notifier = notifier;
    }

    public void save(Conta conta) {
        dao.save(conta);
    }

    @Override
    public void saque(String numero, Double valor) {
        dao.saque(numero, valor);
        notifier.sendMessage("Saque no valor: " + valor + " realizado com sucesso!");
    }

    public List<Conta> findAll() {
        return dao.findAll();
    }

}

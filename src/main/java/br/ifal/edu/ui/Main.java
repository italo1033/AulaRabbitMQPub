package br.ifal.edu.ui;

import br.ifal.edu.domain.Conta;
import br.ifal.edu.infra.MysqlContaDao;
import br.ifal.edu.infra.message.Notifier;
import br.ifal.edu.service.ContaService;
import br.ifal.edu.service.IContaService;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        int opc = 0;
        IContaService service = new ContaService(new MysqlContaDao(), new Notifier());

        Scanner scanner = new Scanner(System.in);
        do {

            System.out.print("Digite a opc desejada: ");
            opc = scanner.nextInt();

            if (opc == 1) {
                System.out.print("Digite o numero: ");
                String numero = scanner.next();
                System.out.print("Digite a agencia: ");
                String agencia = scanner.next();
                System.out.print("Digite o nome: ");
                String nome = scanner.next();

                Conta conta = new Conta(numero, agencia, nome);
                service.save(conta);
            }

            if (opc == 2) {
                var list = service.findAll();
                for (Conta conta : list) {
                    System.out.println("Conta: " + conta);
                }

            }

            if (opc == 3) {
                System.out.print("Digite o numero: ");
                String numero = scanner.next();
                System.out.print("Digite o numero: ");
                double valor = scanner.nextDouble();
                service.saque(numero, valor);
            }

        } while (opc != 0);

    }
}
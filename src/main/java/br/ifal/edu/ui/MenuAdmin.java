package br.ifal.edu.ui;
import br.ifal.edu.infra.connection.EcommerceDao;
import br.ifal.edu.model.Order;
import br.ifal.edu.model.Product;

import java.util.Scanner;
public class MenuAdmin{

    private final Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        boolean executando = true;

        while (executando) {
            System.out.println("\n--- MENU ADMIN ---");
            System.out.println("1. Monitorar todos os pedidos");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> mostrarPedidosAdmin();
                case 0 -> executando = false;
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void mostrarPedidosAdmin() {
        System.out.println("\n--- TODOS OS PEDIDOS ---");
        if (EcommerceDao.pedidos.isEmpty()) {
            System.out.println("Nenhum pedido encontrado.");
            return;
        }

        for (Order pedido : EcommerceDao.pedidos) {
            System.out.println("Pedido #" + pedido.id + " - Cliente: " + pedido.user.name);
            for (Product p : pedido.products) {
                System.out.printf(" - %s (R$ %.2f)\n", p.name, p.price);
            }
            System.out.printf("Total: R$ %.2f\n", pedido.totalAmount);
            System.out.println("Status: " + pedido.status + "\n");
        }
    }
}

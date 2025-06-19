package br.ifal.edu.ui;
import br.ifal.edu.infra.connection.EcommerceDao;
import br.ifal.edu.infra.message.INotifier;
import br.ifal.edu.infra.message.Notifier;
import br.ifal.edu.model.Order;
import br.ifal.edu.model.User;

import java.util.List;
import java.util.Scanner;

public class MakePurchase implements IMenuClient {
    INotifier notifier = new Notifier();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void executar(User user) {
        System.out.println("\n--- SUAS COMPRAS ---");
        List<Order> pedidosUsuario = EcommerceDao.pedidos.stream()
                .filter(p -> p.user.id == user.id)
                .toList();

        if (pedidosUsuario.isEmpty()) {
            System.out.println("Você não possui pedidos.");
            return;
        }

        pedidosUsuario.forEach(p -> {
            System.out.println("Pedido #" + p.id);
            p.products.forEach(prod ->
                    System.out.println(" - " + prod.name + " (R$ " + prod.price + ")"));
            System.out.printf("Total: R$ %.2f\n", p.totalAmount);
            System.out.println("Status: " + p.status + "\n");
        });

        System.out.print("Digite o ID do pedido para finalizar (ou 0 para voltar): ");
        int idPedido;
        try {
            idPedido = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
            return;
        }

        if (idPedido == 0) {
            return;
        }

        Order pedidoParaFinalizar = pedidosUsuario.stream()
                .filter(p -> p.id == idPedido)
                .findFirst()
                .orElse(null);

        if (pedidoParaFinalizar == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        if ("Finalizado".equalsIgnoreCase(pedidoParaFinalizar.status)) {
            System.out.println("Pedido já está finalizado.");
            return;
        }

        pedidoParaFinalizar.status = "Finalizado";
        notifier.sendMessage("Pedido # " + idPedido + " finalizado com sucesso!", "fila-pedidos");
    }
}

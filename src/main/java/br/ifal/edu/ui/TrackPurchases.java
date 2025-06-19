package br.ifal.edu.ui;
import br.ifal.edu.infra.connection.EcommerceDao;
import br.ifal.edu.infra.message.INotifier;
import br.ifal.edu.infra.message.Notifier;
import br.ifal.edu.model.Order;
import br.ifal.edu.model.Product;
import br.ifal.edu.model.User;
import br.ifal.edu.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrackPurchases implements IMenuClient {
    INotifier notifier = new Notifier();
    private final Scanner scanner = new Scanner(System.in);
    private final OrderService orderService = new OrderService();

    @Override
    public void executar(User user) {
        List<Product> carrinho = new ArrayList<>();

        while (true) {
            System.out.print("Digite texto para buscar produtos (ou 0 para finalizar compra): ");
            String filtro = scanner.nextLine();

            if (filtro.equals("0")) {
                break;
            }

            List<Product> produtosFiltrados = buscarProdutos(filtro);

            if (produtosFiltrados.isEmpty()) {
                System.out.println("Nenhum produto encontrado para o filtro: " + filtro);
                continue;
            }

            exibirProdutos(produtosFiltrados);

            System.out.print("Digite o ID do produto para adicionar ao carrinho (ou 0 para finalizar): ");
            int id;
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ID inválido. Tente novamente.");
                continue;
            }

            if (id == 0) {
                break;
            }

            Product produtoSelecionado = produtosFiltrados.stream()
                    .filter(p -> p.id == id)
                    .findFirst()
                    .orElse(null);

            if (produtoSelecionado != null) {
                carrinho.add(produtoSelecionado);
                System.out.println(produtoSelecionado.name + " adicionado ao carrinho.");
            } else {
                System.out.println("Produto não encontrado no resultado da busca.");
            }
        }

        if (!carrinho.isEmpty()) {
            long orderID = orderService.createOrder(user, carrinho);
            System.out.println("Pedido realizada com sucesso!");
            notifier.sendMessage("Pedido número " + orderID + " emitido com sucesso!", "fila-pedidos");


        } else {
            System.out.println("Nenhum produto foi selecionado.");
        }
    }

    private List<Product> buscarProdutos(String filtro) {
        String filtroLower = filtro.toLowerCase();
        List<Product> resultados = new ArrayList<>();
        for (Product p : EcommerceDao.produtos) {
            if (String.valueOf(p.id).contains(filtroLower)
                    || p.name.toLowerCase().contains(filtroLower)
                    || String.format("%.2f", p.price).contains(filtroLower)
                    || String.valueOf(p.stock).contains(filtroLower)) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    private void exibirProdutos(List<Product> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto para exibir.");
            return;
        }
        System.out.println("\n--- PRODUTOS DISPONÍVEIS ---");
        for (Product p : produtos) {
            System.out.printf("ID: %d | Nome: %s | Preço: R$ %.2f | Estoque: %d\n",
                    p.id, p.name, p.price, p.stock);
        }
    }
}

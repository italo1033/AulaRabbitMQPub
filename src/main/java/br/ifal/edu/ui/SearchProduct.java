package br.ifal.edu.ui;

import br.ifal.edu.infra.connection.EcommerceDao;
import br.ifal.edu.model.Product;
import br.ifal.edu.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchProduct implements IMenuClient {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void executar(User user) {
        boolean buscaRealizada = false;

        while (true) {
            if (!buscaRealizada) {
                System.out.print("Digite texto para buscar em qualquer campo: ");
                String filtro = scanner.nextLine().toLowerCase();

                List<Product> resultados = buscarProdutos(filtro);
                exibirProdutos(resultados);

                if (resultados.isEmpty()) {
                    System.out.println("Nenhum produto encontrado para o filtro: " + filtro);
                }
                System.out.println();
                buscaRealizada = true;
            }

            System.out.println("\nDigite:");
            System.out.println("1 - Nova pesquisa");
            System.out.println("2 - Listar todos os produtos");
            System.out.println("0 - Voltar ao menu");

            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            if (opcao.equals("2")) {
                exibirProdutos(EcommerceDao.produtos);
            } else if (opcao.equals("1")) {
                System.out.print("Digite texto para buscar em qualquer campo: ");
                String filtro = scanner.nextLine().toLowerCase();

                List<Product> resultados = buscarProdutos(filtro);
                exibirProdutos(resultados);

                if (resultados.isEmpty()) {
                    System.out.println("Nenhum produto encontrado para o filtro: " + filtro);
                }
                System.out.println();
            } else if (opcao.equals("0")) {
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
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

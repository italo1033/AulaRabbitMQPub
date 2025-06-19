package br.ifal.edu.ui;
import br.ifal.edu.model.User;

import java.util.Scanner;

public class MenuClient {

    private final Scanner scanner = new Scanner(System.in);

    private final IMenuClient pesquisaAction = new SearchProduct();
    private final IMenuClient compraAction = new TrackPurchases();
    private final IMenuClient acompanharAction = new MakePurchase();

    public void exibirMenu(User user) {
        boolean executando = true;

        while (executando) {
            System.out.println("\n--- MENU CLIENTE ---");
            System.out.println("1. Pesquisar Produtos");
            System.out.println("2. Realizar Compra");
            System.out.println("3. Acompanhar Compras");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> pesquisaAction.executar(user);
                case 2 -> compraAction.executar(user);
                case 3 -> acompanharAction.executar(user);
                case 0 -> executando = false;
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}

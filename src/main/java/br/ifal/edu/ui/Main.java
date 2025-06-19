package br.ifal.edu.ui;
import br.ifal.edu.infra.connection.EcommerceDao;
import br.ifal.edu.model.Product;
import br.ifal.edu.model.User;
import br.ifal.edu.service.AuthService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        inicializarDados();
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();

        boolean sistemaAtivo = true;

        while (sistemaAtivo) {
            System.out.println("\n=== LOGIN ===");
            System.out.println("Digite 1 para fazer login ou 0 para sair do sistema:");
            String opcao = scanner.nextLine();

            if (opcao.equals("0")) {
                sistemaAtivo = false;
                System.out.println("Sistema encerrado.");
                break;
            }

            User usuario = authService.autenticarUsuario();

            if (usuario == null) {
                System.out.println("Usuário ou senha inválidos.\n");
                continue;
            }

            System.out.println("\nBem-vindo, " + usuario.name + "!");

            if ("admin".equalsIgnoreCase(usuario.tipo)) {
                new MenuAdmin().exibirMenu();
            } else {
                new MenuClient().exibirMenu(usuario);
            }

            // Após o menu, retorna ao login
            System.out.println("\nVocê saiu do menu. Retornando ao login...");
        }

        scanner.close();
    }

    private static void inicializarDados() {
        // Produtos
        EcommerceDao.produtos.add(new Product(1, "Notebook Dell", 4500.00, 10, 2.5));
        EcommerceDao.produtos.add(new Product(2, "Smartphone Samsung", 2500.00, 25, 0.3));
        EcommerceDao.produtos.add(new Product(3, "Monitor LG 24\"", 899.99, 15, 3.2));

        // Usuários
        EcommerceDao.usuarios.add(new User(1, "João Cliente", "c", "123", "cliente"));
        EcommerceDao.usuarios.add(new User(2, "Ana Admin", "admin@email.com", "admin123", "admin"));
        EcommerceDao.usuarios.add(new User(3, "Italo", "italo@email.com", "12", "admin"));
    }
}

package br.ifal.edu.service;
import br.ifal.edu.infra.connection.EcommerceDao;
import br.ifal.edu.model.User;

import java.util.Scanner;

public class AuthService {
    private final Scanner scanner = new Scanner(System.in);

    public User autenticarUsuario() {
        System.out.println("Digite seu e-mail:");
        String email = scanner.nextLine();
        System.out.println("Digite sua senha:");
        String senha = scanner.nextLine();

        return EcommerceDao.usuarios.stream()
                .filter(u -> u.email.equals(email) && u.password.equals(senha))
                .findFirst()
                .orElse(null);
    }
}

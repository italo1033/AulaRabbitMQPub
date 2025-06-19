package br.ifal.edu.infra.connection;

import br.ifal.edu.model.Order;
import br.ifal.edu.model.Product;
import br.ifal.edu.model.User;

import java.util.ArrayList;
import java.util.List;
public class EcommerceDao {
    public static List<Product> produtos = new ArrayList<>();
    public static List<User> usuarios = new ArrayList<>();
    public static List<Order> pedidos = new ArrayList<>();

    private static int lastOrderId = 0;

    public static int getNextOrderId() {
        return ++lastOrderId;
    }

}

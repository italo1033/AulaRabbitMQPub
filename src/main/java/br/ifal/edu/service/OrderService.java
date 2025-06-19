package br.ifal.edu.service;


import br.ifal.edu.infra.connection.EcommerceDao;
import br.ifal.edu.model.Order;
import br.ifal.edu.model.Product;
import br.ifal.edu.model.User;

import java.util.List;


public class OrderService {

    public long createOrder(User user, List<Product> products) {
        Order newOrder = new Order();
        newOrder.id = (long) EcommerceDao.getNextOrderId();
        newOrder.user = user;
        newOrder.products = products;
        newOrder.totalAmount = products.stream().mapToDouble(p -> p.price).sum();
        newOrder.status = "Em processamento";

        // Adiciona o pedido na lista global simulada
        EcommerceDao.pedidos.add(newOrder);

        // Retorna o número da ordem (ID)
        return newOrder.id;
    }
}

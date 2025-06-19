package br.ifal.edu.model;

import java.util.List;

public class Order {
    public Long id;
    public User user;
    public List<Product> products;
    public String status; // ex: PENDENTE, ENVIADO
    public Double totalAmount;
}

package br.ifal.edu.model;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    Long id;
    User user;
    List<Product> products = new ArrayList<>();

    public Cart(Long id, User user, List<Product> products) {
        this.id = id;
        this.user = user;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

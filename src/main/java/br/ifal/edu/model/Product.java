package br.ifal.edu.model;

public class Product {
    public int id;
    public String name;
    public Double price;
    public Integer stock;
    public Double weight;

    public Product(int id, String name, Double price, Integer stock, Double weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
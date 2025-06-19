package br.ifal.edu.model;
public class Payment {
    Long id;
    Order order;
    String method;
    Double amount;
    String status; // ex: PAGO, REJEITADO

    public Payment(Long id, Order order, String method, Double amount, String status) {
        this.id = id;
        this.order = order;
        this.method = method;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


package br.ifal.edu.model;
public class User {
    public int id;
    public String name;
    public String email;
    public String password;
    public String tipo;

    public User(int id, String name, String email, String password, String tipo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


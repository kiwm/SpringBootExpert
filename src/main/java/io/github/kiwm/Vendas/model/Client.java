package io.github.kiwm.Vendas.model;

import lombok.Data;

@Data
public class Client {
    private int id;
    private String name;

    public Client() {
    }

    public Client(String name) {
        this.name = name;
    }

    public Client(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

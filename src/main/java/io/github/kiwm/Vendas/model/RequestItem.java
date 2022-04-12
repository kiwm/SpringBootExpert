package io.github.kiwm.Vendas.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestItem {
    private int id;
    private Request request;
    private Product product;
    private int amount;
}

package io.github.kiwm.Vendas.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Integer id;
    private String description;
    private BigDecimal unitValue;
}

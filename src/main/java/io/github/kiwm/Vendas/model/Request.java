package io.github.kiwm.Vendas.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Request {
    private int id;
    private Client client;
    private LocalDate dateRequest;
    private BigDecimal total;
}

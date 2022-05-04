package io.github.kiwm.Vendas.repository;

import io.github.kiwm.Vendas.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

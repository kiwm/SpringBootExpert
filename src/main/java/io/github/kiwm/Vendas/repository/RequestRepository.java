package io.github.kiwm.Vendas.repository;

import io.github.kiwm.Vendas.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Integer> {
}

package io.github.kiwm.Vendas.repository;

import io.github.kiwm.Vendas.model.RequestItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestItemRepository extends JpaRepository<RequestItem, Integer> {
}

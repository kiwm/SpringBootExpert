package io.github.kiwm.Vendas.repository;

import io.github.kiwm.Vendas.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface ClientsRepository extends JpaRepository<Client, Integer> {

   List<Client> findByNameLike(String name);
}

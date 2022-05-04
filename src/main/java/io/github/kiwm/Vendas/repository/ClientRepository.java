package io.github.kiwm.Vendas.repository;

import io.github.kiwm.Vendas.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

   @Query(value = "SELECT * FROM client WHERE name LIKE %:name% ", nativeQuery = true)
   List<Client> findByNameTest(@Param("name") String name);


   @Query("select c from Client c left join fetch c.requests")
   Client findClienteFetchPedidos (@Param("id") Integer id);
}

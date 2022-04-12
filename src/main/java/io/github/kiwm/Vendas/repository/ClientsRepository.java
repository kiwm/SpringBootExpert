package io.github.kiwm.Vendas.repository;

import io.github.kiwm.Vendas.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientsRepository {

    private static String INSERT = "insert into client (name) values (?)";
    private static String SELECT_ALL = "SELECT * FROM client";
    private static String UPDATE = "UPDATE client SET name = ? WHERE id = ?";
    private static String DELETE = "DELETE FROM client WHERE id = ?";



    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Client save (Client client) {
        String INSERT = "insert into client (name) values (?)";
        jdbcTemplate.update(INSERT, new Object[]{client.getName()});
        return client;
    }

    public List<Client> listAll() {
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                return new Client(name, id);
            }
        });
    }

    public Client update (Client client) {
        jdbcTemplate.update(UPDATE, new Object[]{client.getName(), client.getId()});
        return client;
    }

    public void delete (Client client) {
        jdbcTemplate.update(DELETE, new Object[]{client.getId()});
    }
}

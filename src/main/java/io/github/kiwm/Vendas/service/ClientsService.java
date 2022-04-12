package io.github.kiwm.Vendas.service;

import io.github.kiwm.Vendas.model.Client;
import io.github.kiwm.Vendas.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    public void saveClient(Client client) {
        validateClient(client);
    }

    public void validateClient(Client client) {
        //aplica as validacoes
    }
}

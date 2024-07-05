package com.firuz.demo.service;

import java.util.List;

import com.firuz.demo.entity.Client;

public interface ClientManagement {
    public String saveClient(Client client);

    public Client getClient(Integer id);

    public List<Client> getClients();
}

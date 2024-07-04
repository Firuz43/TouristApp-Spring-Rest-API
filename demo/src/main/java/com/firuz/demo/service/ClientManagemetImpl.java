package com.firuz.demo.service;

import com.firuz.demo.entity.Client;
import com.firuz.demo.repository.ClientRepo;

public class ClientManagemetImpl implements ClientManagement {

    private ClientRepo clientRepository;

    @Override
    public String saveClient(Client client) {
        return "Client saved" + clientRepository.save(client);
    }
    
}

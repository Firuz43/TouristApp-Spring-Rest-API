package com.firuz.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firuz.demo.entity.Client;
import com.firuz.demo.repository.ClientRepo;

@Service
public class ClientManagemetImpl implements ClientManagement {

    @Autowired
    private ClientRepo clientRepository;

    @Override
    public String saveClient(Client client) {
        return "Client saved" + clientRepository.save(client);
    }

    @Override
    public Client getClient(Integer id) {
        return clientRepository.findById(id).get();
    }
    
}

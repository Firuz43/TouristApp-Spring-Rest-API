package com.firuz.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firuz.demo.entity.Client;
import com.firuz.demo.repository.ClientRepo;

@Service
public class ClientManagemetImpl implements ClientManagement {

    @Autowired
    private ClientRepo clientRepository;
    //
    @Override
    public String saveClient(Client client) {
        return "Client saved" + clientRepository.save(client);
    }
    ///slightly chgne
    @Override
    public Client getClient(Integer id) {
        return clientRepository.findById(id).get();
    }
    

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }


    // @Override
    // public String updateClient(Client client) {
    //     //update api needs to be changed //////
    // }
}

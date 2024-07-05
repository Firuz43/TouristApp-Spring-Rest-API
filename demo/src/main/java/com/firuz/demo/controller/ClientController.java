package com.firuz.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firuz.demo.entity.Client;
import com.firuz.demo.service.ClientManagement;

@RestController
public class ClientController {
    
    @Autowired
    private ClientManagement clientService;

    @PostMapping("/client")
    public String saveClient(@RequestBody Client client) {
        return "save " + clientService.saveClient(client);
    }


    @GetMapping("client/{id}")
    public Client getClient(@PathVariable("id") Integer id) {
        return clientService.getClient(id);
    }

}

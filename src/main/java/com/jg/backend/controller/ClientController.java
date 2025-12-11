package com.jg.backend.controller;

import com.jg.backend.domain.dto.CreateClientRequest;
import com.jg.backend.domain.entity.Client;
import com.jg.backend.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private ClientService ClientService;

    @GetMapping
    private List<Client> getClients() {
        return ClientService.getClients();
    }

    @GetMapping("/{id}")
    private Client getClient(@PathVariable Long id) {
        return ClientService.getClient(id);
    }

    @PostMapping
    private Client createClient(@RequestBody CreateClientRequest createClientRequest) {
        return ClientService.createClient(createClientRequest);
    }

    @PutMapping("/{id}")
    private Client updateClient(@PathVariable Long id, @RequestBody CreateClientRequest createClientRequest) {
        return ClientService.updateClient(id, createClientRequest);
    }

    @DeleteMapping("/{id}")
    private void deleteClient(@PathVariable Long id) {
        ClientService.deleteClient(id);
    }

}

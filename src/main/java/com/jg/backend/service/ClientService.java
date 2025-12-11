package com.jg.backend.service;

import com.jg.backend.domain.dto.CreateClientRequest;
import com.jg.backend.domain.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getClients();
    Client getClient(Long id);
    Client createClient(CreateClientRequest createClientRequest);
    Client updateClient(Long id, CreateClientRequest createClientRequest);
    void deleteClient(Long id);

}

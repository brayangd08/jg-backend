package com.jg.backend.service.impl;

import com.jg.backend.domain.dto.CreateClientRequest;
import com.jg.backend.domain.entity.Client;
import com.jg.backend.exception.JgNotFoundException;
import com.jg.backend.repository.ClientRepository;
import com.jg.backend.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new JgNotFoundException("Client with id " + id + " not found."));
    }

    @Override
    public Client createClient(CreateClientRequest createClientRequest) {
        Client client = createClientRequestToClient(createClientRequest);

        return clientRepository.save(client);
    }

    private static Client createClientRequestToClient(CreateClientRequest createClientRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(createClientRequest.getDateBirth(), formatter);

        return Client.builder()
                .name(createClientRequest.getName())
                .lastName(createClientRequest.getLastName())
                .age(createClientRequest.getAge())
                .email(createClientRequest.getEmail())
                .idCardNumber(createClientRequest.getIdCardNumber())
                .dateBirth(localDate)
                .build();
    }

    @Override
    public Client updateClient(Long id, CreateClientRequest createClientRequest) {
        Client client = getClient(id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(createClientRequest.getDateBirth(), formatter);

        client.setName(createClientRequest.getName());
        client.setLastName(createClientRequest.getLastName());
        client.setIdCardNumber(createClientRequest.getIdCardNumber());
        client.setAge(createClientRequest.getAge());
        client.setEmail(createClientRequest.getEmail());
        client.setDateBirth(localDate);

        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}

package com.jg.backend.service;

import com.jg.backend.domain.dto.CreateClienteRequest;
import com.jg.backend.domain.entity.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> getClientes();
    Cliente getCliente(Long id);
    Cliente createCliente(CreateClienteRequest createClienteRequest);
    Cliente updateCliente(Long id, CreateClienteRequest createClienteRequest);
    void deleteCliente(Long id);

}

package com.jg.backend.service.impl;

import com.jg.backend.domain.dto.CreateClienteRequest;
import com.jg.backend.domain.entity.Cliente;
import com.jg.backend.exception.JgNotFoundException;
import com.jg.backend.repository.ClienteRepository;
import com.jg.backend.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getCliente(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new JgNotFoundException("Cliente con id " + id + "no encontrado."));
    }

    @Override
    public Cliente createCliente(CreateClienteRequest createClienteRequest) {
        Cliente cliente = createClienteRequestToCliente(createClienteRequest);

        return clienteRepository.save(cliente);
    }

    private static Cliente createClienteRequestToCliente(CreateClienteRequest createClienteRequest) {
        return Cliente.builder()
                .nombre(createClienteRequest.getNombre())
                .apellido(createClienteRequest.getApellido())
                .edad(createClienteRequest.getEdad())
                .email(createClienteRequest.getEmail())
                .cedula(createClienteRequest.getCedula())
                .fechaNacimiento(createClienteRequest.getFechaNacimiento())
                .build();
    }

    @Override
    public Cliente updateCliente(Long id, CreateClienteRequest createClienteRequest) {
        Cliente cliente = getCliente(id);

        cliente.setNombre(createClienteRequest.getNombre());
        cliente.setApellido(createClienteRequest.getApellido());
        cliente.setCedula(createClienteRequest.getCedula());
        cliente.setEdad(createClienteRequest.getEdad());
        cliente.setEmail(createClienteRequest.getEmail());
        cliente.setFechaNacimiento(createClienteRequest.getFechaNacimiento());

        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}

package com.jg.backend.controller;

import com.jg.backend.domain.dto.CreateClienteRequest;
import com.jg.backend.domain.entity.Cliente;
import com.jg.backend.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping
    private List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @GetMapping("/{id}")
    private Cliente getCliente(@PathVariable Long id) {
        return clienteService.getCliente(id);
    }

    @PostMapping
    private Cliente createCliente(@RequestBody CreateClienteRequest createClienteRequest) {
        return clienteService.createCliente(createClienteRequest);
    }

    @PutMapping("/{id}")
    private Cliente updateCliente(@PathVariable Long id, @RequestBody CreateClienteRequest createClienteRequest) {
        return clienteService.updateCliente(id, createClienteRequest);
    }

    @DeleteMapping("/{id}")
    private void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }

}

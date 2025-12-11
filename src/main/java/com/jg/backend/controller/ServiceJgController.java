package com.jg.backend.controller;

import com.jg.backend.domain.dto.CreateServiceJgRequest;
import com.jg.backend.domain.entity.ServiceJg;
import com.jg.backend.service.ServiceJgService;
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
@RequestMapping("/serviceJg")
public class ServiceJgController {

    private ServiceJgService serviceJgService;

    @GetMapping
    private List<ServiceJg> getServiceJgs() {
        return serviceJgService.getServiceJgs();
    }

    @GetMapping("/{id}")
    private ServiceJg getServiceJg(@PathVariable Long id) {
        return serviceJgService.getServiceJg(id);
    }

    @PostMapping
    private ServiceJg createServiceJg(@RequestBody CreateServiceJgRequest createServiceJgRequest) {
        return serviceJgService.createServiceJg(createServiceJgRequest);
    }

    @PutMapping("/{id}")
    private ServiceJg updateServiceJg(@PathVariable Long id, @RequestBody CreateServiceJgRequest createServiceJgRequest) {
        return serviceJgService.updateServiceJg(id, createServiceJgRequest);
    }

    @DeleteMapping("/{id}")
    private void deleteServiceJg(@PathVariable Long id) {
        serviceJgService.deleteServiceJg(id);
    }
    
}

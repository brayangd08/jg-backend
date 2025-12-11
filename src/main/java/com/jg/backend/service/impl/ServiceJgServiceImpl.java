package com.jg.backend.service.impl;

import com.jg.backend.domain.dto.CreateServiceJgRequest;
import com.jg.backend.domain.entity.ServiceJg;
import com.jg.backend.exception.JgNotFoundException;
import com.jg.backend.repository.ServiceJgRepository;
import com.jg.backend.service.ServiceJgService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceJgServiceImpl implements ServiceJgService {

    private ServiceJgRepository serviceJgRepository;

    @Override
    public List<ServiceJg> getServiceJgs() {
        return serviceJgRepository.findAll();
    }

    @Override
    public ServiceJg getServiceJg(Long id) {
        return serviceJgRepository.findById(id).orElseThrow(() -> new JgNotFoundException("ServiceJg with id " + id + " not found"));
    }

    @Override
    public ServiceJg createServiceJg(CreateServiceJgRequest createServiceJgRequest) {
        ServiceJg ServiceJg = createServiceJgRequestToServiceJg(createServiceJgRequest);

        return serviceJgRepository.save(ServiceJg);
    }

    private ServiceJg createServiceJgRequestToServiceJg(CreateServiceJgRequest createServiceJgRequest) {
        return ServiceJg.builder().name(createServiceJgRequest.getName()).price(createServiceJgRequest.getPrice()).description(createServiceJgRequest.getDescription()).build();
    }

    @Override
    public ServiceJg updateServiceJg(Long id, CreateServiceJgRequest createServiceJgRequest) {
        ServiceJg ServiceJg = getServiceJg(id);

        ServiceJg.setName(createServiceJgRequest.getName());
        ServiceJg.setDescription(createServiceJgRequest.getDescription());
        ServiceJg.setPrice(createServiceJgRequest.getPrice());

        return serviceJgRepository.save(ServiceJg);
    }

    @Override
    public void deleteServiceJg(Long id) {
        serviceJgRepository.deleteById(id);
    }

}

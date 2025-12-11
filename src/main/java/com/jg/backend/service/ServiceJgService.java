package com.jg.backend.service;

import com.jg.backend.domain.dto.CreateServiceJgRequest;
import com.jg.backend.domain.entity.ServiceJg;

import java.util.List;

public interface ServiceJgService {

    List<ServiceJg> getServiceJgs();
    ServiceJg getServiceJg(Long id);
    ServiceJg createServiceJg(CreateServiceJgRequest createServiceJgRequest);
    ServiceJg updateServiceJg(Long id, CreateServiceJgRequest createServiceJgRequest);
    void deleteServiceJg(Long id);
}

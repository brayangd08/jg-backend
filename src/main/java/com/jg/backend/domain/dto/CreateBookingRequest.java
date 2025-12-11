package com.jg.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingRequest {

    private String startDate;
    private String endDate;
    private List<Long> serviceJgIds;
    private List<CreateBookingProductRequest> products;

}

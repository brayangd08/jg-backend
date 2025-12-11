package com.jg.backend.domain.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateClientRequest {

    private String name;
    private String lastName;
    private String email;
    private int age;
    private String dateBirth;
    @Column(unique = true)
    private String idCardNumber;

}

package com.example.OneToOne.dtos.responses;

import lombok.Data;

@Data
public class GetAddress {
    private Long id;
    private String street;
    private String zipCode;
}

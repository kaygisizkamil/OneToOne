package com.example.OneToOne.dtos.responses;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter

public class GetAddress {
    private Long id;
    private String street;
    private String zipCode;
}

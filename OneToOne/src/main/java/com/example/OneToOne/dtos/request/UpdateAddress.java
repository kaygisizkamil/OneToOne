package com.example.OneToOne.dtos.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UpdateAddress {
    @JsonIgnore
    Long id;
    private String street;
    private String zipCode;
}

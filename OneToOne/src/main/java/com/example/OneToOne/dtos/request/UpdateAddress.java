package com.example.OneToOne.dtos.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UpdateAddress {
    private String street;
    private String zipCode;
}

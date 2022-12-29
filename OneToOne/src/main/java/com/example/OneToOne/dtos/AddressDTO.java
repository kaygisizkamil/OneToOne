package com.example.OneToOne.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class AddressDTO {
        private Long id;
        private String street;
        private String zipCode;

        //... getters and setters for the fields
}

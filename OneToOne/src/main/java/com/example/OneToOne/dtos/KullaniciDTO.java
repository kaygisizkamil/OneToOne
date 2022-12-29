package com.example.OneToOne.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class KullaniciDTO {
        private Long id;
        private String name;
        private AddressDTO address;

        //... getters and setters for the fields
}

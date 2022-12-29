package com.example.OneToOne.dtos.request;

import com.example.OneToOne.dtos.AddressDTO;
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

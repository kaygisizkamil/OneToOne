package com.example.OneToOne.dtos.request;

import lombok.Data;

@Data
public class AddKullanici {
    private String name;
    private AddAddres addres;
}

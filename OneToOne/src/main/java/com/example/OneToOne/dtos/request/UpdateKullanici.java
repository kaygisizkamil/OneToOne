package com.example.OneToOne.dtos.request;

import com.example.OneToOne.dtos.responses.GetAddress;
import lombok.Data;

@Data
public class UpdateKullanici {
    private  String  name;
    private GetAddress getAddress;
}

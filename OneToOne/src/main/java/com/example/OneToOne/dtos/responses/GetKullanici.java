package com.example.OneToOne.dtos.responses;

import com.example.OneToOne.domain.Addres;
import com.example.OneToOne.domain.Kullanici;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;
@Data
@Setter
@Getter

public class GetKullanici {
   /* private Long id;
    private String street;
    private String zipCode;

    @OneToOne(mappedBy = "addres")
    private Kullanici kullanici;*/
    private Long id;
    private String name;
    private GetAddress getAddress ;

}

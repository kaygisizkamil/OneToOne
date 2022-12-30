package com.example.OneToOne.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Addres {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        private String street;
        private String zipCode;

        @OneToOne(cascade = CascadeType.PERSIST,mappedBy = "addres",fetch = FetchType.LAZY)
        private Kullanici kullanici;


}

package com.example.OneToOne.controller;

import com.example.OneToOne.business.abstracts.AddressService;
import com.example.OneToOne.dtos.AddressDTO;
import com.example.OneToOne.dtos.request.AddAddres;
import com.example.OneToOne.dtos.request.UpdateAddress;
import com.example.OneToOne.dtos.responses.GetAddress;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

        private AddressService addressService;
        @Autowired
        public AddressController(AddressService addressService){
            this.addressService=addressService;
        }

        @PostMapping
        public ResponseEntity<AddAddres> createAddress(@RequestBody AddAddres addAddres) {
            AddAddres createdAddress = addressService.createAddress(addAddres);
            return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<GetAddress> getAddressById(@PathVariable Long id) {
            GetAddress getAddress = addressService.getAddressById(id);
            if (getAddress == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(getAddress, HttpStatus.OK);
        }

        @GetMapping
        public ResponseEntity<List<GetAddress>> getAllAddresses() {
            List< GetAddress> addresses = addressService.getAllAddresses();
            return new ResponseEntity<>(addresses, HttpStatus.OK);
        }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateAddress> updateAddress(@PathVariable Long id, @RequestBody UpdateAddress updateAddress) {
        UpdateAddress updatedAddress = addressService.updateAddress(id, updateAddress);
        if (updatedAddress == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

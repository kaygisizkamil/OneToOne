package com.example.OneToOne.business.abstracts;

import com.example.OneToOne.dtos.AddressDTO;
import com.example.OneToOne.dtos.request.AddAddres;
import com.example.OneToOne.dtos.request.UpdateAddress;
import com.example.OneToOne.dtos.responses.GetAddress;

import java.util.List;

public interface AddressService {
        AddAddres createAddress(AddAddres addAddres);
        GetAddress getAddressById(Long id);
        public List<GetAddress> getAllAddresses();
        public UpdateAddress updateAddress(Long id, UpdateAddress updateAddress);
        void deleteAddress(Long id);
}
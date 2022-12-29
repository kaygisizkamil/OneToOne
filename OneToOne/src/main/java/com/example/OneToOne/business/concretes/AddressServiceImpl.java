package com.example.OneToOne.business.concretes;

import com.example.OneToOne.business.abstracts.AddressService;
import com.example.OneToOne.domain.Addres;
import com.example.OneToOne.dtos.AddressDTO;
import com.example.OneToOne.dtos.partial_mapping.AddressMapping;
import com.example.OneToOne.dtos.request.AddAddres;
import com.example.OneToOne.dtos.request.UpdateAddress;
import com.example.OneToOne.dtos.responses.GetAddress;
import com.example.OneToOne.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
        @Autowired
        private AddressRepository addressRepository;
           private AddressMapping addressMapping =AddressMapping.getInstance();
            @Override
            public AddAddres createAddress(AddAddres addAddres) {
                Addres addres =addressMapping.convertAddressDTOToEntity(addAddres);
                addres = addressRepository.save(addres);//in case u wanna use cascade merge
                return addressMapping.convertAddAddressEntityToDto(addres);
            }

            @Override
            public GetAddress getAddressById(Long id) {
                Addres addres = addressRepository.findById(id).orElse(null);
                if (addres == null) {
                    return null;
                }
                return addressMapping.convertGetAddressEntityToDto(addres);
            }

            @Override
            public List<GetAddress> getAllAddresses() {
                List<Addres> addresses = addressRepository.findAll();
                return addresses.stream()
                        .map(address -> addressMapping.convertGetAddressEntityToDto(address))
                        .collect(Collectors.toList());
                /*    List<Address> addresses = addressRepository.findAll();
    List<GetAddress> getAddresses = new ArrayList<>();
    for (Address address : addresses) {
        GetAddress getAddress = convertAddressToGetAddress(address);
        getAddresses.add(getAddress);
    }
    return getAddresses; they are same*/
            }
            @Transactional
        @Override
        public UpdateAddress updateAddress(Long id, UpdateAddress updateAddress) {
            Addres addres = addressRepository.findById(id).orElse(null);
            if (addres == null) {
                return null;
            }
            addres =addressMapping.convertAddressDTOToEntity(updateAddress);
            return addressMapping.convertUpdateAddressEntityToDto(addres);
        }
        @Override
        public void deleteAddress(Long id) {
            addressRepository.deleteById(id);
            this.addressRepository.flush();
        }
    }
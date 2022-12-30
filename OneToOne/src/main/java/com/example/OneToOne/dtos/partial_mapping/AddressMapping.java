package com.example.OneToOne.dtos.partial_mapping;

import com.example.OneToOne.domain.Addres;
import com.example.OneToOne.dtos.request.AddAddres;
import com.example.OneToOne.dtos.request.UpdateAddress;
import com.example.OneToOne.dtos.responses.GetAddress;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapping {
    private static final ModelMapper modelMapper = new ModelMapper();
   private static AddressMapping instance;
    private AddressMapping() {
    }
    public static AddressMapping getInstance() {
        if (instance == null) {
            instance = new AddressMapping();
        }
        return instance;
    }
    public GetAddress convertGetAddressEntityToDto(Addres addres){
        GetAddress getAddress=modelMapper.map(addres,GetAddress.class);
        return getAddress;
    }
    public UpdateAddress convertUpdateAddressEntityToDto(Addres addres){
        UpdateAddress updateAddress=modelMapper.map(addres,UpdateAddress.class);
        return updateAddress;
    }
    public AddAddres convertAddAddressEntityToDto(Addres addres){
        AddAddres addAddres=modelMapper.map(addres,AddAddres.class);
        return addAddres;
    }
    public static <T> Addres convertAddressDTOToEntity(T value) {
        Addres addres = new Addres();
        addres = modelMapper.map(value, Addres.class);
        return addres;
    }

  /*  public <T, S> T convertAddressEntityToDto(S addressDTO, Class<T> clazz) {
        if (addressDTO instanceof GetAddress || addressDTO instanceof UpdateAddress ) {
            T toDto = modelMapper.map(addressDTO, clazz);
            return toDto;
        }
        return null;
    }*/




}







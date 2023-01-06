package com.example.OneToOne.business.concretes;

import com.example.OneToOne.business.abstracts.AddressService;
import com.example.OneToOne.domain.Addres;
import com.example.OneToOne.dtos.request.AddAddres;
import com.example.OneToOne.dtos.responses.GetAddress;
import com.example.OneToOne.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import com.example.OneToOne.dtos.request.*;

class AddressServiceImplTest {

    @InjectMocks
    private AddressService addressService = new AddressServiceImpl();

    @Mock
    private AddressRepository addressRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAddress() {
        AddAddres addAddress = new AddAddres();
        addAddress.setStreet("123 Main St");
        addAddress.setZipCode("12345");
        Addres address = new Addres();
        address.setStreet(addAddress.getStreet());
        address.setZipCode(addAddress.getZipCode());
        when(addressRepository.save(any(Addres.class))).thenReturn(address);
        AddAddres result = addressService.createAddress(addAddress);

        assertNotNull(result);
        assertEquals(addAddress.getStreet(), result.getStreet());
        assertEquals(addAddress.getZipCode(), result.getZipCode());

        verify(addressRepository).save(any(Addres.class));
    }

    @Test
    void getAddressById() {
        Addres address = new Addres();
        address.setId(1L);
        address.setStreet("123 Main St");
        address.setZipCode("12345");
        when(addressRepository.findById(anyLong())).thenReturn(Optional.of(address));
        GetAddress result = addressService.getAddressById(1L);
        assertNotNull(result);
        assertEquals(address.getId(), result.getId());
        assertEquals(address.getStreet(), result.getStreet());
        assertEquals(address.getZipCode(), result.getZipCode());
        verify(addressRepository).findById(anyLong());
    }

    @Test
    void getAllAddresses() {
            Addres address1 = new Addres();
            address1.setId(1L);
            address1.setStreet("123 Main St");
            address1.setZipCode("12345");
            Addres address2 = new Addres();
            address2.setId(2L);
            address2.setStreet("456 Main St");
            address2.setZipCode("54321");
            when(addressRepository.findAll()).thenReturn(Arrays.asList(address1, address2));
            List<GetAddress> result = addressService.getAllAddresses();
            assertNotNull(result);
            assertEquals(2, result.size());
            GetAddress result1 = result.get(0);
            assertEquals(address1.getId(), result1.getId());
            assertEquals(address1.getStreet(), result1.getStreet());
            assertEquals(address1.getZipCode(), result1.getZipCode());
            GetAddress result2 = result.get(1);
            assertEquals(address2.getId(), result2.getId());
            assertEquals(address2.getStreet(), result2.getStreet());
            assertEquals(address2.getZipCode(), result2.getZipCode());

            verify(addressRepository).findAll();

    }

    @Test
    void updateAddress() {
        UpdateAddress updateAddress = new UpdateAddress();
        updateAddress.setStreet("123 Main St");
        updateAddress.setZipCode("12345");

        Addres address = new Addres();
        address.setId(1L);
        address.setStreet("456 Main St");
        address.setZipCode("54321");

        when(addressRepository.findById(anyLong())).thenReturn(Optional.of(address));
        when(addressRepository.save(any(Addres.class))).thenReturn(address);
        UpdateAddress result = addressService.updateAddress(1L, updateAddress);
        assertNotNull(result);
        assertEquals(updateAddress.getStreet(), result.getStreet());
        assertEquals(updateAddress.getZipCode(), result.getZipCode());
        verify(addressRepository).findById(anyLong());
        verify(addressRepository).save(any(Addres.class));
    }

    @Test
    void deleteAddress() {
        // Set up mock behavior
        doNothing().when(addressRepository).deleteById(anyLong());
        // Call method under test
        addressService.deleteAddress(1L);
        // Verify that deleteById was called with the correct argument
        verify(addressRepository).deleteById(1L);
    }
}
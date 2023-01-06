package com.example.OneToOne.business.abstracts;

import com.example.OneToOne.business.concretes.KullaniciServiceImpl;
import com.example.OneToOne.domain.Addres;
import com.example.OneToOne.domain.Kullanici;
import com.example.OneToOne.dtos.KullaniciDTO;
import com.example.OneToOne.dtos.request.AddAddres;
import com.example.OneToOne.dtos.request.AddKullanici;
import com.example.OneToOne.dtos.request.UpdateKullanici;
import com.example.OneToOne.dtos.responses.GetAddress;
import com.example.OneToOne.dtos.responses.GetKullanici;
import com.example.OneToOne.repository.AddressRepository;
import com.example.OneToOne.repository.KullaniciRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KullaniciServiceTest {
    @InjectMocks
    private KullaniciService kullaniciService=new KullaniciServiceImpl();

    @Mock
    private KullaniciRepository kullaniciRepository;
    
 
    @Test
    public void testDeleteKullanici() {
        kullaniciService.deleteKullanici(1L);
        GetKullanici kullanici = kullaniciService.getKullaniciById(1L);
        assertNull(kullanici);
    }
}
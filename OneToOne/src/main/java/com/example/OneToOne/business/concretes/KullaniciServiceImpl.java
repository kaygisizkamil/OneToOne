package com.example.OneToOne.business.concretes;

import com.example.OneToOne.business.abstracts.KullaniciService;
import com.example.OneToOne.domain.Addres;
import com.example.OneToOne.domain.Kullanici;
import com.example.OneToOne.dtos.partial_mapping.KullaniciMapping;
import com.example.OneToOne.dtos.request.AddKullanici;
import com.example.OneToOne.dtos.request.UpdateKullanici;
import com.example.OneToOne.dtos.responses.GetKullanici;
import com.example.OneToOne.repository.AddressRepository;
import com.example.OneToOne.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KullaniciServiceImpl implements KullaniciService {


    @Autowired
    private KullaniciRepository kullaniciRepository;
    @Autowired
    private AddressRepository addressRepository;
    private static KullaniciMapping kullaniciMapping = KullaniciMapping.getInstance();

    @Override
    public AddKullanici createKullanici(AddKullanici addKullanici) {
        Kullanici kullanici = kullaniciMapping.convertKullaniciDTOToEntity(addKullanici);
        Addres address = new Addres();
        address.setStreet(addKullanici.getAddres().getStreet());
        address.setZipCode(addKullanici.getAddres().getZipCode());
        address = addressRepository.save(address);
        kullanici.setAddres(address);
        kullanici = kullaniciRepository.save(kullanici);
        return kullaniciMapping.convertAddKullaniciToDto(kullanici);
    }
    @Override
    public GetKullanici getKullaniciById(Long id) {
        Kullanici kullanici = kullaniciRepository.findById(id).orElse(null);
        if (kullanici == null) {
            return null;
        }
        return kullaniciMapping.convertGetKullaniciEntityToDto(kullanici);
    }

    @Override
    public List<GetKullanici> getAllKullanicilar() {
        List<Kullanici> kullanicilar = kullaniciRepository.findAll();
        List<GetKullanici> getKullanicilar = new ArrayList<>();
        for (Kullanici kullanici : kullanicilar) {
            GetKullanici getKullanici = kullaniciMapping.convertGetKullaniciEntityToDto(kullanici);
            getKullanicilar.add(getKullanici);
        }
        return getKullanicilar;
    }

    @Override
    public UpdateKullanici updateKullanici(Long id, UpdateKullanici updateKullanici) {
        Kullanici kullanici = kullaniciRepository.findById(id).orElse(null);
        if (kullanici == null) {
            return null;
        }
        kullanici = kullaniciMapping.convertKullaniciDTOToEntity(updateKullanici);
        Addres address = kullanici.getAddres();
        address = addressRepository.save(address);
        kullanici.setAddres(address);
        kullanici = kullaniciRepository.save(kullanici);
        return kullaniciMapping.convertUpdateKullaniciToDto(kullanici);
    }

    @Override
    public void deleteKullanici(Long id) {
        kullaniciRepository.deleteById(id);
    }
}
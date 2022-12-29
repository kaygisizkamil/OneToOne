package com.example.OneToOne.business.concretes;

import com.example.OneToOne.business.abstracts.KullaniciService;
import com.example.OneToOne.domain.Addres;
import com.example.OneToOne.domain.Kullanici;
import com.example.OneToOne.dtos.AddressDTO;
import com.example.OneToOne.dtos.KullaniciDTO;
import com.example.OneToOne.repository.AddressRepository;
import com.example.OneToOne.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class KullaniciServiceImpl implements KullaniciService {

    @Autowired
    private KullaniciRepository kullaniciRepository;
    @Autowired AddressRepository addressRepository;
   // @Autowired
 //   private AddressService addressService;


    @Override
    public KullaniciDTO createKullanici(KullaniciDTO kullaniciDTO) {
        //AddressMapping.convertAddressDTOToEntity(new AddressDto());
        Kullanici kullanici = new Kullanici();
        kullanici.setName(kullaniciDTO.getName());
        kullanici.setAddres(convertAddressDTOToEntity(kullaniciDTO.getAddress()));
        kullanici = kullaniciRepository.save(kullanici);
        return convertToDTO(kullanici);
    }
    @Override
    public KullaniciDTO getKullaniciById(Long id) {
        Kullanici kullanici = kullaniciRepository.findById(id).orElse(null);
        if (kullanici == null) {
            return null;
        }
        return convertToDTO(kullanici);
    }


    private KullaniciDTO convertToDTO(Kullanici kullanici) {
        KullaniciDTO kullaniciDTO = new KullaniciDTO();
        kullaniciDTO.setId(kullanici.getId());
        kullaniciDTO.setName(kullanici.getName());
        kullaniciDTO.setAddress(convertAddressEntityToDTO(kullanici.getAddres()));
        return kullaniciDTO;
    }
    private Addres convertAddressDTOToEntity(AddressDTO addressDTO) {
        Addres addres = new Addres();
        addres.setId(addressDTO.getId());
        addres.setStreet(addressDTO.getStreet());
        addres.setZipCode(addressDTO.getZipCode());
        return addres;
    }
    private AddressDTO convertAddressEntityToDTO(Addres addres) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(addres.getId());
        addressDTO.setStreet(addres.getStreet());
        addressDTO.setZipCode(addres.getZipCode());
        return addressDTO;
    }

    /***
     *
     */

    @Override
    public List<KullaniciDTO> getAllKullanicilar() {
        List<Kullanici> kullanicilar = kullaniciRepository.findAll();
        return kullanicilar.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public KullaniciDTO updateKullanici(Long id, KullaniciDTO kullaniciDTO) {
        Kullanici kullanici = kullaniciRepository.findById(id).orElse(null);
        if (kullanici == null) {
            return null;
        }
        kullanici.setName(kullaniciDTO.getName());
        kullanici.setAddres(convertAddressDTOToEntity(kullaniciDTO.getAddress()));
        kullanici = kullaniciRepository.save(kullanici);
        return convertToDTO(kullanici);
    }

    @Override
    public void deleteKullanici(Long id) {
        kullaniciRepository.deleteById(id);
    }
}

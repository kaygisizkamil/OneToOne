package com.example.OneToOne.dtos.partial_mapping;

import com.example.OneToOne.domain.Addres;
import com.example.OneToOne.domain.Kullanici;
import com.example.OneToOne.dtos.request.AddKullanici;
import com.example.OneToOne.dtos.request.UpdateKullanici;
import com.example.OneToOne.dtos.responses.GetAddress;
import com.example.OneToOne.dtos.responses.GetKullanici;
import org.modelmapper.ModelMapper;

public class KullaniciMapping {
    private static final ModelMapper modelMapper = new ModelMapper();
    private static KullaniciMapping instance;
    private KullaniciMapping() {
    }
    public static KullaniciMapping getInstance() {
        if (instance == null) {
            instance = new KullaniciMapping();
        }
        return instance;
    }

    public GetKullanici convertGetKullaniciEntityToDto(Kullanici kullanici) {
        GetKullanici getKullanici = modelMapper.map(kullanici, GetKullanici.class);
        GetAddress getAddress = modelMapper.map(kullanici.getAddres(), GetAddress.class);
        getKullanici.setGetAddress(getAddress);
        return getKullanici;
    }
    public AddKullanici convertAddKullaniciToDto(Kullanici kullanici){
        AddKullanici addKullanici=modelMapper.map(kullanici,AddKullanici.class);
        return addKullanici;
    }
    public UpdateKullanici convertUpdateKullaniciToDto(Kullanici kullanici){
        UpdateKullanici updateKullanici=modelMapper.map(kullanici,UpdateKullanici.class);
        return updateKullanici;
    }

    public static <T> Kullanici convertKullaniciDTOToEntity(T value) {
        Kullanici kullanici = new Kullanici();
        kullanici = modelMapper.map(value, Kullanici.class);
        return kullanici;

    }
}

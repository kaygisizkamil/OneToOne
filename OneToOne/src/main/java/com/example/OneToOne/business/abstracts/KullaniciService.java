package com.example.OneToOne.business.abstracts;

import com.example.OneToOne.dtos.KullaniciDTO;

import java.util.List;

public interface KullaniciService {

    KullaniciDTO createKullanici(KullaniciDTO kullaniciDTO);
    KullaniciDTO getKullaniciById(Long id);
    List<KullaniciDTO> getAllKullanicilar();
    KullaniciDTO updateKullanici(Long id, KullaniciDTO kullaniciDTO);
    void deleteKullanici(Long id);

}

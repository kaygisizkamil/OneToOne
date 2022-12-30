package com.example.OneToOne.business.abstracts;

import com.example.OneToOne.dtos.request.AddKullanici;
import com.example.OneToOne.dtos.request.UpdateKullanici;
import com.example.OneToOne.dtos.responses.GetKullanici;

import java.util.List;

public interface KullaniciService {

    AddKullanici createKullanici(AddKullanici addKullanici);
   // KullaniciDTO getKullaniciById(Long id);
    public GetKullanici getKullaniciById(Long id);
    List<GetKullanici> getAllKullanicilar();
    UpdateKullanici updateKullanici(Long id, UpdateKullanici updateKullanici);
    void deleteKullanici(Long id);

}

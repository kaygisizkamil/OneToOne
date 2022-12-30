package com.example.OneToOne.controller;

import com.example.OneToOne.business.abstracts.KullaniciService;
import com.example.OneToOne.dtos.request.AddKullanici;
import com.example.OneToOne.dtos.request.UpdateKullanici;
import com.example.OneToOne.dtos.responses.GetKullanici;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/kullanici")
@RestController
public class KullaniciController {
    @Autowired
    private KullaniciService kullaniciService;

    @PostMapping
    public ResponseEntity<AddKullanici> createKullanici(@RequestBody AddKullanici addKullanici) {
        AddKullanici createdKullanici = kullaniciService.createKullanici(addKullanici);
        return ResponseEntity.ok(createdKullanici);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetKullanici> getKullaniciById(@PathVariable Long id) {
        GetKullanici kullanici = kullaniciService.getKullaniciById(id);
        if (kullanici == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(kullanici);
    }

    @GetMapping
    public ResponseEntity<List<GetKullanici>> getAllKullanicilar() {
        List<GetKullanici> kullanicilar = kullaniciService.getAllKullanicilar();
        return ResponseEntity.ok(kullanicilar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateKullanici> updateKullanici(@PathVariable Long id, @RequestBody UpdateKullanici
                                                                                                updateKullanici) {
        UpdateKullanici updatedKullanici = kullaniciService.updateKullanici(id, updateKullanici);
        if (updatedKullanici == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedKullanici);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKullanici(@PathVariable Long id) {
        kullaniciService.deleteKullanici(id);
        return ResponseEntity.noContent().build();
    }
}
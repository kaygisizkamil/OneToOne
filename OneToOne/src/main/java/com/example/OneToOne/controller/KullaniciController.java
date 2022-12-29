package com.example.OneToOne.controller;

import com.example.OneToOne.business.abstracts.KullaniciService;
import com.example.OneToOne.dtos.KullaniciDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/kullanici")
@RestController
public class KullaniciController {

        private KullaniciService kullaniciService;
        @Autowired
        public KullaniciController(KullaniciService kullaniciService){
            this.kullaniciService=kullaniciService;
        }

        @PostMapping
        public ResponseEntity<KullaniciDTO> createKullanici(@RequestBody KullaniciDTO userDTO) {
            KullaniciDTO createdKullanici = kullaniciService.createKullanici(userDTO);
            return new ResponseEntity<>(createdKullanici, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<KullaniciDTO> getKullaniciById(@PathVariable Long id) {
            KullaniciDTO user = kullaniciService.getKullaniciById(id);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        @GetMapping
        public ResponseEntity<List<KullaniciDTO>> getAllKullanicilar() {
            List<KullaniciDTO> users = kullaniciService.getAllKullanicilar();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<KullaniciDTO> updateKullanici(@PathVariable Long id, @RequestBody KullaniciDTO userDTO) {
            KullaniciDTO updatedKullanici = kullaniciService.updateKullanici(id, userDTO);
            if (updatedKullanici == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(updatedKullanici, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteKullanici(@PathVariable Long id) {
            kullaniciService.deleteKullanici(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


}

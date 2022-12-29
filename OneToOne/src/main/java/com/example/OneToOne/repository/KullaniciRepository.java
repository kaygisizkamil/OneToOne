package com.example.OneToOne.repository;

import com.example.OneToOne.domain.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici,Long> {
}

package com.example.OneToOne.repository;

import com.example.OneToOne.domain.Addres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Addres,Long> {
    void deleteById(Long id);
}

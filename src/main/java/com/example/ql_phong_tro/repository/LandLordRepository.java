package com.example.ql_phong_tro.repository;

import com.example.ql_phong_tro.model.entity.LandLord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LandLordRepository extends JpaRepository<LandLord,Integer> {
    Optional<LandLord> findByPhone(String phone);
}

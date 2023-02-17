package com.example.ql_phong_tro.repository;

import com.example.ql_phong_tro.model.entity.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenterRepository extends JpaRepository<Renter,Integer> {
}

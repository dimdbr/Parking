package com.example.parking.repository;

import com.example.parking.model.Accountant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountantRepository extends JpaRepository<Accountant,Integer> {
}

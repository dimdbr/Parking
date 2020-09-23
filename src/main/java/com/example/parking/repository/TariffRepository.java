package com.example.parking.repository;

import com.example.parking.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TariffRepository extends JpaRepository<Tariff,Integer> {
}

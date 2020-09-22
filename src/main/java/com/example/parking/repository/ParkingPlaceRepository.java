package com.example.parking.repository;

import com.example.parking.model.ParkingPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingPlaceRepository extends JpaRepository<ParkingPlace,Integer> {
}

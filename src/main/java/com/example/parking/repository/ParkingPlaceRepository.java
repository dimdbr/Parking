package com.example.parking.repository;

import com.example.parking.model.ParkingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ParkingPlaceRepository extends JpaRepository<ParkingPlace,Integer> {
    @Query(value = "select * from parkingplaces where contractid = ?1",nativeQuery = true)
    List<ParkingPlace> getParkingPlaceByContractId(UUID contractId);
}

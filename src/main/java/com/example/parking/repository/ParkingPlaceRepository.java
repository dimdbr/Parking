package com.example.parking.repository;

import com.example.parking.model.ParkingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParkingPlaceRepository extends JpaRepository<ParkingPlace,Integer> {
    @Query(value = "select * from parkingplaces where contractid = ?1",nativeQuery = true)
    List<ParkingPlace> getParkingPlaceByContractId(String contractId);
}

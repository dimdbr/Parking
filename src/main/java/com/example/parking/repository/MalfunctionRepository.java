package com.example.parking.repository;

import com.example.parking.model.Malfunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MalfunctionRepository  extends JpaRepository<Malfunction, UUID> {
    @Query(value = "SELECT * from malfunctions where ispayed=?1 ",nativeQuery = true)
    List<Malfunction> readMalfunctionByPayed(boolean ispayed);

}

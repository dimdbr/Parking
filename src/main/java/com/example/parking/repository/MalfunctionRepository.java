package com.example.parking.repository;

import com.example.parking.model.Malfunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MalfunctionRepository  extends JpaRepository<Malfunction, UUID> {
    @Query(value = "SELECT * from malfunctions where ispayed=true ",nativeQuery = true)
    List<Malfunction> readUnpayed();
    @Query(value = "SELECT * from malfunctions where ispayed=false ",nativeQuery = true)
    List<Malfunction> readPayed();
}

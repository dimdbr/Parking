package com.example.parking.repository;

import com.example.parking.model.Malfunction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MalfunctionRepository  extends JpaRepository<Malfunction, UUID> {
}

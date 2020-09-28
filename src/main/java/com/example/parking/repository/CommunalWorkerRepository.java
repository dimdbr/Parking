package com.example.parking.repository;

import com.example.parking.model.CommunalWorker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommunalWorkerRepository extends JpaRepository<CommunalWorker, UUID> {
}

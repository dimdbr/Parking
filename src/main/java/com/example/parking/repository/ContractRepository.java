package com.example.parking.repository;

import com.example.parking.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ContractRepository extends JpaRepository<Contract, UUID> {

    @Query( value = "SELECT * FROM contracts where clientid=?1",nativeQuery = true)
    Contract findByClientId(UUID clientId);
}

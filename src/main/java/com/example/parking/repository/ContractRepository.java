package com.example.parking.repository;

import com.example.parking.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract,String> {
}

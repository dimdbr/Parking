package com.example.parking.repository;

import com.example.parking.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContractRepository extends JpaRepository<Contract,String> {

    @Query( value = "SELECT * FROM contracts where clientid=?1",nativeQuery = true)
    Contract findByClientId(String clientId);
}

package com.example.parking.repository;

import com.example.parking.model.CoOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoOwnersRepository extends JpaRepository<CoOwner,Integer> {
}

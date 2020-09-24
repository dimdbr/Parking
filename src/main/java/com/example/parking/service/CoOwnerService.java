package com.example.parking.service;

import com.example.parking.model.CoOwner;
import javassist.NotFoundException;

import java.util.List;

public interface CoOwnerService {
    List<CoOwner> readCoOwner();
    CoOwner readCoOwner(int id) throws NotFoundException;
    CoOwner addToBalance(int id, double incomes) throws NotFoundException;
}

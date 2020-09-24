package com.example.parking.service.impl;

import com.example.parking.model.CoOwner;
import com.example.parking.repository.CoOwnersRepository;
import com.example.parking.service.CoOwnerService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoOwnerServiceImpl implements CoOwnerService {
    @Autowired
    private CoOwnersRepository coOwnersRepository;

    @Override
    public List<CoOwner> readCoOwner() {
        return coOwnersRepository.findAll();
    }

    @Override
    public CoOwner readCoOwner(int id) throws NotFoundException {
        Optional<CoOwner> coOwnertemp = coOwnersRepository.findById(id);
        if(coOwnertemp.isPresent())
            return coOwnersRepository.findById(id).get();
        else
            throw  new NotFoundException(String.format("Owner with this id dont exist"));
    }

    @Override
    public CoOwner addToBalance(int id, double incomes) throws NotFoundException{
        CoOwner coOwnertemp = coOwnersRepository.findById(id).get();
        coOwnertemp.addIncome(incomes);
        return coOwnersRepository.save(coOwnertemp);
    }
}

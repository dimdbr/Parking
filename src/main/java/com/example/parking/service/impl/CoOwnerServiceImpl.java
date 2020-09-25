package com.example.parking.service.impl;

import com.example.parking.model.Client;
import com.example.parking.model.CoOwner;
import com.example.parking.model.CommunalWorker;
import com.example.parking.repository.AccountantRepository;
import com.example.parking.repository.ClientRepository;
import com.example.parking.repository.CoOwnersRepository;
import com.example.parking.repository.CommunalWorkerRepository;
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
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CommunalWorkerRepository communalWorkerRepository;
    @Autowired
    AccountantRepository accountantRepository;
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

    @Override
    public CoOwner collectMoney(int id) throws NotFoundException{
        List<Client> clients = clientRepository.findAll();
        CoOwner coOwner = coOwnersRepository.getOne(id);
        int numberOfOwners = 2;
        double totalIncome=0.0;
        for(Client client:clients)
        {
            totalIncome+=client.getMonthPay();
        }
        coOwner.addIncome(totalIncome/numberOfOwners);
         return coOwnersRepository.save(coOwner);


    }

    @Override
    public void payMoney() {
        List<CoOwner>coOwners = coOwnersRepository.findAll();
        List<CommunalWorker> communalWorkers = communalWorkerRepository.findAll();
        double totalWorkPrice=0;
        for(CommunalWorker communalWorker:communalWorkers)
        {
            totalWorkPrice+=communalWorker.getSalary();

        }
        for(CoOwner coOwner:coOwners)
        {
            coOwner.addIncome(-totalWorkPrice/coOwners.size());
            coOwnersRepository.save(coOwner);
        }
    }
}

package com.example.parking.service.impl;

import com.example.parking.model.*;
import com.example.parking.repository.*;
import com.example.parking.service.ExpensesIncomeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpensesIncomeServiceImpl implements ExpensesIncomeService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AccountantRepository accountantRepository;
    @Autowired
    private CommunalWorkerRepository communalWorkerRepository;
    @Autowired
    private MalfunctionRepository malfunctionRepository;
    @Autowired
    private TariffRepository tariffRepository;




    @Override
    public List<Accountant> readAllAccountants() {
        return accountantRepository.findAll();
    }

    @Override
    public Accountant readAccountant(int id) throws NotFoundException {
        Optional<Accountant> accountantTemp = accountantRepository.findById(id);
        if(accountantTemp.isPresent())
            return accountantRepository.findById(id).get();
        else
            throw new NotFoundException(String.format("Accountant with id %s dont exist",id));
    }

    @Override
    public Accountant updateSalary(int id, double salary) throws NotFoundException {
        Optional<Accountant> accountantTemp = accountantRepository.findById(id);
        if(accountantTemp.isPresent()) {
            Accountant accountant = accountantTemp.get();
            accountant.setSalary(salary);
            return accountantRepository.save(accountant);
        }
        else
            throw new NotFoundException(String.format("Accountant with id %s dont exist",id));
    }

    @Override
    public void setPayPriceForClients() throws NotFoundException {
        List<Client> clients=clientRepository.findAll();
        List<CommunalWorker> communalWorkers=communalWorkerRepository.findAll();
        List<Malfunction> malfunctions = malfunctionRepository.findAll();
        List<Accountant> accountants = accountantRepository.findAll();
        Tariff tariff=tariffRepository.getOne(1);
        double payPriceTotal=0;
        for(CommunalWorker communalWorker: communalWorkers)
        {
            payPriceTotal+=communalWorker.getSalary();
        }
        for(Accountant accountant: accountants)
        {
            payPriceTotal+=accountant.getSalary();
        }
        for (Malfunction malfunction:malfunctions)
        {
            if (!malfunction.isPayed())
            {
                payPriceTotal+=malfunction.getFixPrice();
                malfunction.changeStatus();
                malfunctionRepository.save(malfunction);
            }
        }
        int numberOfClients = clients.size();
        double payPrice = payPriceTotal/numberOfClients+
                tariff.getPlacePrice()+
                tariff.getElectricityTariff()+
                tariff.getGasTariff()+
                tariff.getWaterTariff();

        for(Client client: clients)
        {
            client.setMonthPay(payPrice);
            clientRepository.save(client);
        }
    }
}

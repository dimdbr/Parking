package com.example.parking.service;

import com.example.parking.model.Tariff;
import javassist.NotFoundException;

import javax.persistence.Table;
import java.util.List;

public interface TariffService {

    Tariff createTariff(Tariff tariff);
    List<Tariff> readAllTariff();

    Tariff readTariff(int id) throws NotFoundException;

    Tariff updateTariff(int id, Tariff tariff) throws NotFoundException;




}

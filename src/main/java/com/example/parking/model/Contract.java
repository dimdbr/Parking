package com.example.parking.model;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "contracts")
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
public  final class Contract {

    @Id
    @Column(name = "id",updatable = false, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String ContractId;
    @Column(name = "clientid")
    private String ClientId;

    @Type(type = "list-array")
    @Column(name = "registeredcars")
    private List<String> registeredCars;

    public Contract(String contractId, String clientId, List<String> registeredCars) {
        ContractId = contractId;
        ClientId = clientId;

        this.registeredCars = registeredCars;
    }
    public Contract()
    {}

    public Contract(String clientId, String carName)
    {   this.ContractId= UUID.randomUUID().toString();
        this.ClientId= clientId;

        this.registeredCars.add(carName);
    }
    public Contract(String clientId, List<String> carNames)
    {
        this.ContractId=UUID.randomUUID().toString();
        this.ClientId= clientId;

        this.registeredCars=carNames;
    }

    public String getContractId() {
        return ContractId;
    }

    public String getClientId() {
        return ClientId;
    }



    public List<String> getRegisteredCars() {
        return registeredCars;
    }

    public void setClientId(String clientId) {
        ClientId = clientId;
    }

    public Contract removeClientCar(String carName)
    {
        if(this.registeredCars.contains(carName))
        { this.registeredCars.remove(carName);
        }
        return this;
    }

    public Contract addClientCar(String carName)
    {
        if(this.registeredCars.contains(carName)) {
        }
        else
        {
            this.registeredCars.add(carName);
        }
        return this;
    }




}

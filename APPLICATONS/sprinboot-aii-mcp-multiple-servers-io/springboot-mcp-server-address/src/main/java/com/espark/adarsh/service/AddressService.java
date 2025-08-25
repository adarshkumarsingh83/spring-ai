package com.espark.adarsh.service;

import com.espark.adarsh.entity.Address;
import com.espark.adarsh.exception.AddressNotFoundException;
import com.espark.adarsh.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Tool(description = "Get All Address")
    public List<Address> getAllAddress() {
        List<Address> addressList = new LinkedList<>();
        this.addressRepository.findAll().forEach(address -> addressList.add(address));
        return addressList;
    }

    @Tool(description = "get address data by id")
    public Address getAddress(Long id) {
        return this.addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("address not found"));
    }

    @Tool(description = "create new address data")
    public Address saveAddress(Address address) {
        return this.addressRepository.save(address);
    }

    @Tool(description = "update address by id and address data")
    public Address updateAddress(Long id, Address address) {
        return this.addressRepository.save(address);
    }

    @Tool(description = "delete address for id ")
    public Address removeAddress(Long id) {
        Address employee = this.addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("address not found"));
        this.addressRepository.deleteById(id);
        return employee;
    }
}


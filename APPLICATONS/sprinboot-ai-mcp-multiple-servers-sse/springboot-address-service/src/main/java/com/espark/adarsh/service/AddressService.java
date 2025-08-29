package com.espark.adarsh.service;

import com.espark.adarsh.entity.Address;
import com.espark.adarsh.exception.AddressNotFoundException;
import com.espark.adarsh.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Supplier<List<Address>> allAddress = () -> {
        List<Address> addressList = new LinkedList<>();
        this.addressRepository.findAll().forEach(address -> addressList.add(address));
        return addressList;
    };

    public Function<Long,Address> addressByAddressId = (Long addressId) -> {
        return this.addressRepository.findById(addressId)
                .orElseThrow(() -> new AddressNotFoundException("address not found"));
    };

    public Function<Address,Address> createAddress = (Address address) -> {
        return this.addressRepository.save(address);
    };

    public BiFunction<Long,Address,Address> updateAddress = (Long addressId, Address address) -> {
        return this.addressRepository.save(address);
    };

    public Function<Long,Address> removeAddressByAddressId = (Long addressId) ->{
        Address employee = this.addressRepository.findById(addressId)
                .orElseThrow(() -> new AddressNotFoundException("address not found"));
        this.addressRepository.deleteById(addressId);
        return employee;
    };
}


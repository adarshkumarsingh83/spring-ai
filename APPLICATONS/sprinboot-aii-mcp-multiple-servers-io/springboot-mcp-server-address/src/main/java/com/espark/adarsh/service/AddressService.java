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

    @Tool(name = "get_all_address", description = "Get All Address in the system ")
    public List<Address> getAllAddress() {
        List<Address> addressList = new LinkedList<>();
        this.addressRepository.findAll().forEach(address -> addressList.add(address));
        return addressList;
    }

    @Tool(name = "get_address_by_address_id", description = "get address data by provided address id")
    public Address getAddressByAddressId(Long id) {
        return this.addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("address not found"));
    }

    @Tool(name = "create_address", description = "create new address data by passing address object which contains address data")
    public Address createAddress(Address address) {
        return this.addressRepository.save(address);
    }

    @Tool(name="update_address",description = "update address based on address id and address data ")
    public Address updateAddress(Long id, Address address) {
        return this.addressRepository.save(address);
    }

    @Tool(name = "remove_address_by_address_id", description = "delete address based on address id ")
    public Address removeAddressByAddressId(Long id) {
        Address employee = this.addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("address not found"));
        this.addressRepository.deleteById(id);
        return employee;
    }
}


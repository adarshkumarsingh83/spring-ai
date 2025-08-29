package com.espark.adarsh.web;

import com.espark.adarsh.entity.Address;
import com.espark.adarsh.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/addresses")
    public List<Address> getAllAddress() {
        return this.addressService.allAddress.get();
    }

    @GetMapping("/address/{id}")
    public Address getAddressByAddressId(@PathVariable("id") Long id) {
        return this.addressService.addressByAddressId.apply(id);
    }

    @PostMapping("/address")
    public Address createAddress(@RequestBody Address address) {
        return this.addressService.createAddress.apply(address);
    }

    @PutMapping("/address/{id}")
    public Address updateAddress(@PathVariable("id") Long id,@RequestBody Address address) {
        return this.addressService.updateAddress.apply(id,address);
    }

    @DeleteMapping("/address/{id}")
    public Address removeAddressByAddressId(@PathVariable("id") Long id) {
       return this.addressService.removeAddressByAddressId.apply(id);
    }
}


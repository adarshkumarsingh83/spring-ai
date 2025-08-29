package com.espark.adarsh.service;

import com.espark.adarsh.config.ServiceConfig;
import com.espark.adarsh.entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Slf4j
@Service
public class AddressService {

    private ServiceConfig serviceConfig;
    private RestTemplate restTemplate;

    public AddressService(RestTemplate restTemplate, ServiceConfig serviceConfig) {
        this.restTemplate = restTemplate;
        this.serviceConfig = serviceConfig;
    }

    @Tool(name = "get_all_address", description = "Get All Address in the system ")
    public List<Address> getAllAddress() {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept", "application/json");
            String url = serviceConfig.getService().get("address-service").getUrl() + "/addresses";
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<List<Address>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Address>>() {
            });
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception occurred while fetching all addresses: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Tool(name = "get_address_by_address_id", description = "get address data by provided address id")
    public Address getAddressByAddressId(Long id) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept", "application/json");
            String  url = serviceConfig.getService().get("address-service").getUrl() +"/address/" + id;
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<Address> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<Address>() {
            });
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception occurred while fetching address with id {}: {}", id, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Tool(name = "create_address", description = "create new address data by passing address object which contains address data")
    public Address createAddress(Address address) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept", "application/json");
            String url = serviceConfig.getService().get("address-service").getUrl() +"/address";
            HttpEntity<Address> entity = new HttpEntity<>(address, httpHeaders);
            ResponseEntity<Address> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<Address>() {
            });
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception occurred while creating address: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Tool(name = "update_address", description = "update address based on address id and address data ")
    public Address updateAddress(Long id, Address address) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept", "application/json");
            String url = serviceConfig.getService().get("address-service").getUrl() +"/address/" + id;
            HttpEntity<Address> entity = new HttpEntity<>(address, httpHeaders);
            ResponseEntity<Address> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, entity, new ParameterizedTypeReference<Address>() {
            });
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception occurred while updating address with id {}: {}", id, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Tool(name = "remove_address_by_address_id", description = "delete address based on address id ")
    public Address removeAddressByAddressId(Long id) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept", "application/json");
            String url = serviceConfig.getService().get("address-service").getUrl() +"/address/" + id;
            HttpEntity<Address> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<Address> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, entity, new ParameterizedTypeReference<Address>() {
            });
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception occurred while deleting address with id {}: {}", id, e.getMessage());
            throw new RuntimeException(e);
        }
    }

}


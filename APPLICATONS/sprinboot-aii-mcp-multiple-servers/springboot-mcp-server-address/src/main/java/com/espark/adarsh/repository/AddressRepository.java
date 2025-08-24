package com.espark.adarsh.repository;
import com.espark.adarsh.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository <Address,Long>{
}


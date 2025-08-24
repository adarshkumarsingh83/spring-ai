package com.espark.adarsh.repository;
import com.espark.adarsh.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository <Person,Long>{
}


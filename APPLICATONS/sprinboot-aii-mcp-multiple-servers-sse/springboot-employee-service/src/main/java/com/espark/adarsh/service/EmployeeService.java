package com.espark.adarsh.service;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.exception.EmployeeNotFoundException;
import com.espark.adarsh.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Supplier<List<Employee>> allEmployee = () -> {
        List<Employee> employeeList = new LinkedList<>();
        this.employeeRepository.findAll().forEach(employee -> employeeList.add(employee));
        return employeeList;
    };

    public Function<Long,Employee> employeeByEmployeeId = (Long id) -> {
        return this.employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("employee not found"));
    };

    public Function<Employee,Employee> createEmployee = ( Employee employee) -> {
        return this.employeeRepository.save(employee);
    };

    public BiFunction<Long,Employee,Employee> updateEmployee = (Long id, Employee employee) -> {
        return this.employeeRepository.save(employee);
    };

    public Function<Long,Employee> removeEmployeeByEmployeeId = (Long id) -> {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("employee not found"));
        this.employeeRepository.deleteById(id);
        return employee;
    };

}

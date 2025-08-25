package com.espark.adarsh.service;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.exception.EmployeeNotFoundException;
import com.espark.adarsh.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Tool(description = "get all employees data")
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new LinkedList<>();
        this.employeeRepository.findAll().forEach(employee -> employeeList.add(employee));
        return employeeList;
    }

    @Tool(description = "get employee data by id")
    public Employee getEmployee(Long id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("employee not found"));
    }

    @Tool(description = "create new employee data")
    public Employee saveEmployee( Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Tool(description = "update employee data by id and employee data")
    public Employee updateEmployee(Long id, Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Tool(description = "delete employee data for id")
    public Employee removeEmployee(Long id) {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("employee not found"));
        this.employeeRepository.deleteById(id);
        return employee;
    }

}

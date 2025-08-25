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

    @Tool(name = "get_all_employees", description = "get all employees data in the system")
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new LinkedList<>();
        this.employeeRepository.findAll().forEach(employee -> employeeList.add(employee));
        return employeeList;
    }

    @Tool(name = "get_employee_by_employee_id", description = "get employee data based on provided employee id")
    public Employee getEmployeeByEmployeeId(Long id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("employee not found"));
    }

    @Tool(name="create_employee", description = "create new employee in the system")
    public Employee createEmployee( Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Tool(name="update_employee",description = "update employee data by id and employee data")
    public Employee updateEmployee(Long id, Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Tool(name="remove_employee_by_employee_id",description = "delete employee data for id")
    public Employee removeEmployeeByEmployeeId(Long id) {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("employee not found"));
        this.employeeRepository.deleteById(id);
        return employee;
    }

}

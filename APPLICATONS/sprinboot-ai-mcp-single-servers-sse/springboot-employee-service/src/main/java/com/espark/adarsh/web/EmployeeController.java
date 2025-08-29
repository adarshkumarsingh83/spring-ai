package com.espark.adarsh.web;

import com.espark.adarsh.entity.Employee;
import com.espark.adarsh.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return this.employeeService.allEmployee.get();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeByEmployeeId(@PathVariable("id")Long  id) {
        return this.employeeService.employeeByEmployeeId.apply(id);
    }

  @PostMapping("/employee")
    public Employee createEmployee( @RequestBody Employee employee) {
        return this.employeeService.createEmployee.apply(employee);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee) {
        return this.employeeService.updateEmployee.apply(id,employee);
    }

    @DeleteMapping("/employee/{id}")
    public Employee removeEmployeeByEmployeeId(@PathVariable("id") Long id) {
        return this.employeeService.removeEmployeeByEmployeeId.apply(id);
    }

}

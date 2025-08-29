package com.espark.adarsh.service;

import com.espark.adarsh.config.ServiceConfig;
import com.espark.adarsh.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class EmployeeService {


    private ServiceConfig serviceConfig;
    private RestTemplate restTemplate;

    public EmployeeService(RestTemplate restTemplate, ServiceConfig serviceConfig) {
        this.restTemplate = restTemplate;
        this.serviceConfig = serviceConfig;
    }



    @Tool(name = "get_all_employees", description = "get all employees data in the system")
    public List<Employee> getAllEmployee() {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept", "application/json");
            String url = serviceConfig.getService().get("employee-service").getUrl() + "/employees";
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Employee>>() {
            });
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception occurred while fetching all employees: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Tool(name = "get_employee_by_employee_id", description = "get employee data based on provided employee id")
    public Employee getEmployeeByEmployeeId(Long employeeId) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept", "application/json");
            String  url = serviceConfig.getService().get("employee-service").getUrl() +"/employee/" + employeeId;
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<Employee> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<Employee>() {
            });
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception occurred while fetching employee with id {}: {}", employeeId, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Tool(name="create_employee", description = "create new employee in the system")
    public Employee createEmployee( Employee employee) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept", "application/json");
            String url = serviceConfig.getService().get("employee-service").getUrl() +"/employee";
            HttpEntity<Employee> entity = new HttpEntity<>(employee, httpHeaders);
            ResponseEntity<Employee> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<Employee>() {
            });
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception occurred while creating employee: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Tool(name="update_employee",description = "update employee data by id and employee data")
    public Employee updateEmployee(Long employeeId, Employee employee) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept", "application/json");
            String url = serviceConfig.getService().get("employee-service").getUrl() +"/employee/" + employeeId;
            HttpEntity<Employee> entity = new HttpEntity<>(employee, httpHeaders);
            ResponseEntity<Employee> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, entity, new ParameterizedTypeReference<Employee>() {
            });
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception occurred while updating employee with id {}: {}", employeeId, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Tool(name="remove_employee_by_employee_id",description = "delete employee data for id")
    public Employee removeEmployeeByEmployeeId(Long employeeId) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept", "application/json");
            String url = serviceConfig.getService().get("employee-service").getUrl() +"/employee/" + employeeId;
            HttpEntity<Employee> entity = new HttpEntity<>(httpHeaders);
            ResponseEntity<Employee> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, entity, new ParameterizedTypeReference<Employee>() {
            });
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception occurred while deleting employee with id {}: {}", employeeId, e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

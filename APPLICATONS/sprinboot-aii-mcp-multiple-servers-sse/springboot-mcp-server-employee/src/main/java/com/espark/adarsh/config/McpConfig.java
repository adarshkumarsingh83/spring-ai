package com.espark.adarsh.config;

import com.espark.adarsh.service.EmployeeService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpConfig {

    @Bean
    public ToolCallbackProvider weatherTools(EmployeeService employeeService) {
        return MethodToolCallbackProvider.builder().toolObjects(employeeService).build();
    }
}
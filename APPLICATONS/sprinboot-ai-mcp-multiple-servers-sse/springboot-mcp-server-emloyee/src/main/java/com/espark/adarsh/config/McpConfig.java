package com.espark.adarsh.config;

import com.espark.adarsh.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Configuration
public class McpConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.additionalInterceptors((request, body, execution) -> {
            log.info("Request URI : {} body {} ", request.getURI(), new String(body));
            return execution.execute(request, body);
        }).build();
    }

    @Bean
    public ToolCallbackProvider employeeToolCallbackProvider(EmployeeService employeeService) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(employeeService)
                .build();
    }
}
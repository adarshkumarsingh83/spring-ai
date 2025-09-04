package com.espark.adarsh.config;

import com.espark.adarsh.service.McpGreetUserService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpConfig {

    @Bean
    public ToolCallbackProvider greetToolCallbackProvider(McpGreetUserService mcpGreetUserService) {
        return MethodToolCallbackProvider.builder().toolObjects(mcpGreetUserService).build();
    }
}

package com.espark.adarsh.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "espark.mcp.client")
public class SystemPromptText {

    private String systemPrompt;

}

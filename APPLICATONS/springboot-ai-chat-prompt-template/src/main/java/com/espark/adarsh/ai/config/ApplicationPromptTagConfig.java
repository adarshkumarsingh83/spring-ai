package com.espark.adarsh.ai.config;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "espark.config")
public class ApplicationPromptTagConfig {

    private Map<String,String> tags = new HashMap<>();

    @PostConstruct
    public void init() {
        // Initialize with default tags if needed
       log.info("{}",tags);
    }

    public final Function<String,String> findTagsByKey = (key) -> {
        if (this.tags.containsKey(key)) {
            return this.tags.get(key);
        } else {
            throw new IllegalArgumentException("Tag not found for key: " + key);
        }
    };
}

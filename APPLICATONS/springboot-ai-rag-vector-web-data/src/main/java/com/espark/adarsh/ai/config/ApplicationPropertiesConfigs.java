package com.espark.adarsh.ai.config;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "espark.config")
public class ApplicationPropertiesConfigs {

    private Map<String,String> urls = new HashMap<>();

    private SplitConfig tokenSplit = new SplitConfig();

    @PostConstruct
    public void init() {
        log.info("ApplicationTagConfig : {}", this);
    }

}

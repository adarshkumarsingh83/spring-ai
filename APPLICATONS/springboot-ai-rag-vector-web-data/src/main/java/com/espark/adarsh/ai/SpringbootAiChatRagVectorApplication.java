package com.espark.adarsh.ai;

import com.espark.adarsh.ai.config.ApplicationPropertiesConfigs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationPropertiesConfigs.class)
public class SpringbootAiChatRagVectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAiChatRagVectorApplication.class, args);
	}

}

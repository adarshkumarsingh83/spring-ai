package com.espark.adarsh.ai;

import com.espark.adarsh.ai.config.ApplicationPromptTagConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationPromptTagConfig.class)
public class SpringbootAiChatSystemMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAiChatSystemMessageApplication.class, args);
	}

}

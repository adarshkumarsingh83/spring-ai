package com.espark.adarsh.ai;

import com.espark.adarsh.ai.config.ApplicationTagConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationTagConfig.class)
public class SpringbootAiChatRagVectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAiChatRagVectorApplication.class, args);
	}

}

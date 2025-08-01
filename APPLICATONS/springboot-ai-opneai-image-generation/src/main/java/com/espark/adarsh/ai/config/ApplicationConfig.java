package com.espark.adarsh.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {


    @Bean
    public OpenAiImageOptions openAiImageOptions() {
        return OpenAiImageOptions.builder()
                .model("dall-e-2")
                .quality("hd")
                .height(1024)
                .width(1024)
                .build();
    }
}

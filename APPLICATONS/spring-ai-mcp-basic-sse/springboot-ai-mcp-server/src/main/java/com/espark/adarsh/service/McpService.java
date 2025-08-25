package com.espark.adarsh.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Slf4j
@Service
public class McpService {

    @Tool(name = "wish_action", description = "wish the user based on the time of the day")
    public String wishAction (String input) {
        log.info("Input received in wishAction : {}",input);
        return wishBasedOnTime.apply(input);
    }

    public Function<String,String> wishBasedOnTime = (String userName) -> {
        int hour = java.time.LocalTime.now().getHour();
        String greeting;
        if (hour >= 5 && hour < 12) {
            greeting = "Good Morning";
        } else if (hour >= 12 && hour < 17) {
            greeting = "Good Afternoon";
        } else {
            greeting = "Good Evening";
        }
        return greeting + " " + userName + ", How can I help you?";
    };
}

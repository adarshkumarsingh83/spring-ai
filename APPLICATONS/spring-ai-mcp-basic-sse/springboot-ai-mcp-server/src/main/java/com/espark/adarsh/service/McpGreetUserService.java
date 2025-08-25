package com.espark.adarsh.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Slf4j
@Service
public class McpGreetUserService {

    @Tool(name = "greet_user", description = "this tool is used to greet the user based on time and return the greeting message to the user based on user name ")
    public String greetUser (String input) {
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

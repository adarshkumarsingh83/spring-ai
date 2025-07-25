package com.espark.adarsh.ai.web;

import com.espark.adarsh.ai.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class ApplicationController {

    private ChatService chatService;

    public ApplicationController(ChatService chatService) {
        this.chatService = chatService;
    }


    @GetMapping("/api/chat/{question}")
    public Map<String, String> chat(@PathVariable("question") String question) {
        log.info("Received question: {}", question);
        String response = this.chatService.chatFunction.apply(question);
        log.info("Generated response: {}", response);
        return Map.of("question",question,"response", response);
    }
}

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


    @GetMapping("/api/chat/rag/{subject}")
    public Map<String, String> chat(@PathVariable("tagKey") String tagKey,@PathVariable("subject") String subject) {
        log.info("Received subject: {}", subject);
        Map<String,String> response = this.chatService.chatFunction.apply(subject);
        log.info("Generated response: {}", response);
        return response;
    }
}

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


    @GetMapping("/api/chat/bean/{subject}")
    public Map<String, String> chat(@PathVariable("subject") String subject) {
        log.info("Received subject: {}", subject);
        Map<String,String> response = this.chatService.chatBeanFunction.apply("list",subject);
        log.info("Generated response: {}", response);
        return response;
    }

    @GetMapping("/api/chat/list/{subject}")
    public Map<String, String> chatList(@PathVariable("subject") String subject) {
        log.info("Received subject: {}", subject);
        Map<String,String> response = this.chatService.chatListFunction.apply("list",subject);
        log.info("Generated response: {}", response);
        return response;
    }

    @GetMapping("/api/chat/map/{subject}")
    public Map<String, String> chatMap(@PathVariable("subject") String subject) {
        log.info("Received subject: {}", subject);
        Map<String,String> response = this.chatService.chatMapFunction.apply("list",subject);
        log.info("Generated response: {}", response);
        return response;
    }
}

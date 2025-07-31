package com.espark.adarsh.web;

import com.espark.adarsh.service.ChatService;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
public class ChatController {


    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/ai/generate/{message}")
    public Map generate(@PathVariable("message") String message) {
        return this.chatService.generate.apply(message);
    }

    @GetMapping("/ai/generateStream/{message}")
    public Flux<ChatResponse> generateStream(@PathVariable("message") String message) {
        return this.chatService.generateStream.apply(message);
    }
}

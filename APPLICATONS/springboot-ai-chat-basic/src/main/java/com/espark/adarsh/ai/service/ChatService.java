package com.espark.adarsh.ai.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Slf4j
@Service
public class ChatService {

    private ChatClient chatClient;

    public ChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public final Function<String, String> chatFunction = (question) -> {
        String response = chatClient.prompt().user(question).call().content();
        log.info("Chat response: {}", response);
        return response != null ? response : "No response generated from ai service";
    };
}

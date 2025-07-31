package com.espark.adarsh.service;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.function.Function;

@Service
public class ChatService {

    private OllamaChatModel chatModel;

    public ChatService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public Function<String,Map> generate = (String message) -> {
        return Map.of("generation", chatModel.call(message));
    };

    public Function<String,Flux<ChatResponse>> generateStream= (String message) -> {
        var prompt = new Prompt(new UserMessage(message));
        return chatModel.stream(prompt);
    };
}

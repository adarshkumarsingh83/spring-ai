package com.espark.adarsh.ai.service;

import com.espark.adarsh.ai.config.ApplicationPromptTagConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

@Slf4j
@Service
public class ChatService {

    private ChatClient chatClient;
    private ApplicationPromptTagConfig applicationPromptTagConfig;

    public ChatService(ChatClient chatClient,
                       ApplicationPromptTagConfig applicationPromptTagConfig) {
        this.chatClient = chatClient;
        this.applicationPromptTagConfig = applicationPromptTagConfig;
    }

    public final BiFunction<String, String, Map<String, String>> chatFunction = (tagKey, subject) -> {
        String tag = this.applicationPromptTagConfig.findTagsByKey.apply(tagKey);
        PromptTemplate promptTemplate = new PromptTemplate(tag);
        Prompt prompt = promptTemplate.create(Map.of("subject", subject));
        String response = chatClient.prompt(prompt).call().content();
        log.info("Chat prompt {} response: {}", prompt.getContents(), response);
        return Map.of(prompt.getContents(), response);
    };


}

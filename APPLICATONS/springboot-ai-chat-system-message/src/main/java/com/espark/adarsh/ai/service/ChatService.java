package com.espark.adarsh.ai.service;

import com.espark.adarsh.ai.config.ApplicationPromptTagConfig;
import com.espark.adarsh.ai.function.TriFunction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public final TriFunction<String, String,String, Map<String, String>> chatFunction = (systemTagKey,userTagKey, subject) -> {
        String userTag = this.applicationPromptTagConfig.findUserTagsByKey.apply(userTagKey);
        String systemTag = this.applicationPromptTagConfig.findSystemTagsByKey.apply(systemTagKey);
        SystemMessage systemMessage = new SystemMessage(systemTag);
        UserMessage userMessage = new UserMessage(userTag.replace("{subject}", subject));
        Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
        String response = chatClient.prompt(prompt).call().content();
        log.info("Chat prompt {} response: {}", prompt.getContents(), response);
        return Map.of(prompt.getContents(), response);
    };


}

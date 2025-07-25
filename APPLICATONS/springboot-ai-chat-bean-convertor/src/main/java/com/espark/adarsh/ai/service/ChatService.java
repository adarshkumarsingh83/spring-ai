package com.espark.adarsh.ai.service;

import com.espark.adarsh.ai.config.ApplicationPromptTagConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.BiFunction;

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


    public final BiFunction<String, String, Map<String, String>> chatBeanFunction = (tagKey, subject) -> {
      try {
          String tag = this.applicationPromptTagConfig.findTagsByKey.apply(tagKey);
          String className = this.applicationPromptTagConfig.findCassByKey.apply(subject);
          var outputClass = new BeanOutputConverter<>(Class.forName(className).getClass());
          PromptTemplate promptTemplate = new PromptTemplate(tag);
          Prompt prompt = promptTemplate.create(Map.of("subject", subject,"format",outputClass.getFormat()));
          String response = chatClient.prompt(prompt).call().content();
          log.info("Chat prompt {} response: {}", prompt.getContents(), response);
          return Map.of("prompt",prompt.getContents(),"response", response);
      }catch (Exception e){
            log.error("Error processing chat prompt for tagKey: {}, subject: {}", tagKey, subject, e);
            throw new RuntimeException("Failed to process chat prompt", e);
      }
    };

    public final BiFunction<String, String, Map<String, String>> chatListFunction = (tagKey, subject) -> {
        try {
            String tag = this.applicationPromptTagConfig.findTagsByKey.apply(tagKey);
            var outputClass = new ListOutputConverter(new DefaultConversionService());
            PromptTemplate promptTemplate = new PromptTemplate(tag);
            Prompt prompt = promptTemplate.create(Map.of("subject", subject,"format",outputClass.getFormat()));
            String response = chatClient.prompt(prompt).call().content();
            log.info("Chat prompt {} response: {}", prompt.getContents(), response);
            return Map.of("prompt",prompt.getContents(),"response", response);
        }catch (Exception e){
            log.error("Error processing chat prompt for tagKey: {}, subject: {}", tagKey, subject, e);
            throw new RuntimeException("Failed to process chat prompt", e);
        }
    };

    public final BiFunction<String, String, Map<String, String>> chatMapFunction = (tagKey, subject) -> {
        try {
            String tag = this.applicationPromptTagConfig.findTagsByKey.apply(tagKey);
            var outputClass = new MapOutputConverter();
            PromptTemplate promptTemplate = new PromptTemplate(tag);
            Prompt prompt = promptTemplate.create(Map.of("subject", subject,"format",outputClass.getFormat()));
            String response = chatClient.prompt(prompt).call().content();
            log.info("Chat prompt {} response: {}", prompt.getContents(), response);
            return Map.of("prompt",prompt.getContents(),"response", response);
        }catch (Exception e){
            log.error("Error processing chat prompt for tagKey: {}, subject: {}", tagKey, subject, e);
            throw new RuntimeException("Failed to process chat prompt", e);
        }
    };


}

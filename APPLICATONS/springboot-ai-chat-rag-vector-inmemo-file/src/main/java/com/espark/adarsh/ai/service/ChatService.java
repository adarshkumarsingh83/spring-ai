package com.espark.adarsh.ai.service;

import com.espark.adarsh.ai.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ChatService {

    private VectorStore vectorStore;
    private ChatClient chatClient;

    public ChatService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public final Function<String, Map<String, Object>> chatFunction = ( subject) -> {
        SearchRequest searchQuery =  SearchRequest.builder().query(subject).topK(1).build();
        log.info("Search Query : {}", searchQuery);
         List<Document> documentList = vectorStore.similaritySearch(searchQuery);
         String response =  documentList.stream().map(Document::getFormattedContent)
                 .collect(Collectors.joining(System.lineSeparator()));
        log.info("Response : {}", response);


        var systemPromptTemplate = new SystemPromptTemplate("""
                you are helpful in answering questions use this as base {information} to answer the question.
                """);
        Message systemPrompt = systemPromptTemplate.createMessage(Map.of("information", response));

        var outputConvertor = new BeanOutputConverter<>(Person.class);

        var userMessagePrompt = new PromptTemplate("""
                Tell me about {name} in detail. {format}
                """);
        Message userMessage = new UserMessage(userMessagePrompt.create(Map.of(
                "name", subject,
                "format", outputConvertor.getFormat())).getContents());
         var prompt = new Prompt(List.of(systemPrompt, userMessage));

         var responseData = chatClient.prompt(prompt).call().content();

         var data = outputConvertor.convert(responseData);

        return Map.of(
                "subject", subject,
                "response", data
        );
    };


}

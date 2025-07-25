package com.espark.adarsh.ai.service;

import lombok.extern.slf4j.Slf4j;
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

    public ChatService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public final Function<String, Map<String, String>> chatFunction = ( subject) -> {
        SearchRequest searchQuery =  SearchRequest.builder().query(subject).topK(1).build();
        log.info("Search Query : {}", searchQuery);
         List<Document> documentList = vectorStore.similaritySearch(searchQuery);
         String response =  documentList.stream().map(Document::getFormattedContent)
                 .collect(Collectors.joining(System.lineSeparator()));
        log.info("Response : {}", response);
        return Map.of(
                "subject", subject,
                "response", response
        );
    };


}

package com.espark.adarsh.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;


@Configuration
public class ApplicationConfig {

    private ApplicationTagConfig applicationTagConfig;

    public ApplicationConfig(ApplicationTagConfig applicationTagConfig) {
        this.applicationTagConfig = applicationTagConfig;
    }

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.build();
    }


   @Bean
   public VectorStore vectorStore(EmbeddingModel embeddingModel) {
       VectorStore vectorStore =   SimpleVectorStore.builder(embeddingModel).build();
       vectorStoreConsumer.accept(vectorStore);
       return vectorStore;
    }

    private final Consumer<VectorStore> vectorStoreConsumer = vectorStore -> {
        List<Document> documents =
        applicationTagConfig.getTags()
                .entrySet()
                .stream()
                .map(entry-> {
                  return   new Document( entry.getValue());
                }).toList();
        vectorStore.add(documents);
    };
}

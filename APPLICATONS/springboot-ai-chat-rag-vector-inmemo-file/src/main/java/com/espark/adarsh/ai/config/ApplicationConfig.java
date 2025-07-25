package com.espark.adarsh.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.nio.charset.Charset;
import java.util.List;
import java.util.function.Consumer;


@Configuration
public class ApplicationConfig {

    @Value("classpath:dataStore.txt")
    private Resource resource;

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
       vectorStoreFileConsumer.accept(vectorStore);
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

        var textReader = new TextReader(resource);
        textReader.setCharset(Charset.defaultCharset());
         documents = textReader.get();
        vectorStore.add(documents);
    };

    private final Consumer<VectorStore> vectorStoreFileConsumer = vectorStore -> {
        var textReader = new TextReader(resource);
        textReader.setCharset(Charset.defaultCharset());
        List<Document>  documents = textReader.get();
        vectorStore.add(documents);
    };
}

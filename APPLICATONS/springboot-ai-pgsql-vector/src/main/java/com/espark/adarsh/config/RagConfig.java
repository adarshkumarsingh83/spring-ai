package com.espark.adarsh.config;

import java.util.List;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RagConfig {

    private final VectorStore vectorStore;

    public RagConfig(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @PostConstruct
            public void init(){
        List<Document> documents = List.of(
                new Document(
                        "StarlightDB is a serverless graph database designed for real-time analytics on complex, interconnected data."),
                new Document(
                        "The core of StarlightDB is its 'Quantum-Leap' query engine, which uses speculative execution to deliver query results up to 100x faster than traditional graph databases."),
                new Document(
                        "StarlightDB features 'Chrono-Sync' for effortless time-travel queries, allowing developers to query the state of their graph at any point in the past."),
                new Document(
                        "StarlightDB includes a built-in visualization tool called 'Nebula' that renders interactive 3D graphs directly within the development environment for easier analysis."),
                new Document(
                        "Security in StarlightDB is handled by 'Cosmic Shield', which provides end-to-end encryption and fine-grained access control at the node and edge level."));
        vectorStore.add(documents);
        log.info("Documents loaded into VectorStore.");
    }
}
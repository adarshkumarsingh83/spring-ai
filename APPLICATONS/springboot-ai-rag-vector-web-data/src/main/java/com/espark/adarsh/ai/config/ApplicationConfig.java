package com.espark.adarsh.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import java.util.function.Consumer;
import java.util.function.Function;


@Configuration
public class ApplicationConfig {


    private ApplicationPropertiesConfigs applicationPropertiesConfigs;

    public ApplicationConfig(ApplicationPropertiesConfigs applicationPropertiesConfigs) {
        this.applicationPropertiesConfigs = applicationPropertiesConfigs;
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

    private final Function<String,List<Document>> loadDocumentFunction = (url) -> {
        var documentUri = URI.create(url);
        TikaDocumentReader htmlReader = null;
        try {
            htmlReader = new TikaDocumentReader(new UrlResource(documentUri));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        List<Document> documents = new ArrayList<>(htmlReader.get());
        SplitConfig splitConfig = applicationPropertiesConfigs.getTokenSplit();
        var textSplitter = new TokenTextSplitter(
                splitConfig.getDefaultChunkSize(),
                splitConfig.getMinChunkSizeChars(),
                splitConfig.getMinChunkLengthToEmbed(),
                splitConfig.getMaxNumChunks(),
                splitConfig.isKeepSeparator()
                );
        List<Document> splitDocuments = textSplitter.split(documents);
        return splitDocuments;
    };

    private final Consumer<VectorStore> vectorStoreConsumer = vectorStore -> {
        List<Document> documents =
                applicationPropertiesConfigs.getUrls()
                        .entrySet()
                        .stream()
                        .flatMap(entry ->{
                            return  loadDocumentFunction.apply(entry.getValue()).stream();
                        } ).toList();
        vectorStore.add(documents);
    };


}

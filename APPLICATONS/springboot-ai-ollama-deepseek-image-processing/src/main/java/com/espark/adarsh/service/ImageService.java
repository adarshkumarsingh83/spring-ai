package com.espark.adarsh.service;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.content.Media;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import java.io.InputStream;
import java.util.List;
import java.util.function.BiFunction;

@Service
public class ImageService {

    private OllamaChatModel chatModel;

    public ImageService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public BiFunction<InputStream ,String,ChatResponse> generate = (image, message) -> {
        Resource imageResource = new InputStreamResource(image);
        var userMessage = UserMessage.builder().text(message).media(List.of(new Media(MimeTypeUtils.IMAGE_PNG, imageResource))).build();
        ChatResponse response = chatModel.call(new Prompt(userMessage));
        return  response;
    };


}

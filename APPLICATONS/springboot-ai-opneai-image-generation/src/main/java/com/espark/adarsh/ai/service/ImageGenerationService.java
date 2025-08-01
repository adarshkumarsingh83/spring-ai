package com.espark.adarsh.ai.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Slf4j
@Service
public class ImageGenerationService {

    private OpenAiImageOptions openAiImageOptions;
    private OpenAiImageModel openAiImageModel;

    public ImageGenerationService(OpenAiImageModel openAiImageModel, OpenAiImageOptions openAiImageOptions) {
        this.openAiImageModel = openAiImageModel;
        this.openAiImageOptions = openAiImageOptions;
    }

    public final Function<String, List<String>> imageGenerationFunction = (imageDescription) -> {
        log.info("Generating image for description: {}", imageDescription);
        var imagePrompt = new ImagePrompt(imageDescription, openAiImageOptions);
        ImageResponse response = this.openAiImageModel.call(imagePrompt);
        log.info("Generated image response: {}", response);
        List<String> imageUrls = response.getResults().stream()
                .map(image -> image.getOutput().getUrl())
                .toList();
        log.info("Extracted image URLs: {}", imageUrls);
        return imageUrls;
    };
}

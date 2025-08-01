package com.espark.adarsh.ai.web;

import com.espark.adarsh.ai.service.ImageGenerationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class ApplicationController {

    private ImageGenerationService imageGenerationService;

    public ApplicationController(ImageGenerationService imageGenerationService) {
        this.imageGenerationService = imageGenerationService;
    }


    @GetMapping("/api/image/{image-description}")
    public Map<String, Object> chat(@PathVariable("image-description") String imageDescription) {
        List<String> imageUrls = this.imageGenerationService.imageGenerationFunction.apply(imageDescription);
        log.info("Generated response: {}", imageUrls);
        return Map.of("imageDescription", imageDescription, "imageUrls", imageUrls);
    }
}

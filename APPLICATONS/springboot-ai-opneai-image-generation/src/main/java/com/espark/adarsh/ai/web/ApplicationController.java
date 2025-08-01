package com.espark.adarsh.ai.web;

import com.espark.adarsh.ai.service.ImageGenerationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class ApplicationController {

    private ImageGenerationService imageGenerationService;

    public ApplicationController(ImageGenerationService imageGenerationService) {
        this.imageGenerationService = imageGenerationService;
    }


    @PostMapping("/api/image/generate")
    public Map<String, Object> generateImage(@RequestBody Map<String,String> payload) {
        String imageDescription = payload.get("imageDescription");
        List<String> imageUrls = this.imageGenerationService.imageGenerationFunction.apply(imageDescription);
        log.info("Generated response: {}", imageUrls);
        return Map.of("imageDescription", imageDescription, "imageUrls", imageUrls);
    }
}

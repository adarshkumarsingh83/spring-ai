package com.espark.adarsh.ai.web;

import com.espark.adarsh.ai.service.TextToSpeachService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class ApplicationController {

    private TextToSpeachService textToSpeachService;

    public ApplicationController(TextToSpeachService textToSpeachService) {
        this.textToSpeachService = textToSpeachService;
    }

    @PostMapping("/api/audio/generate")
    public Map<String, Object> generateAudio(@RequestBody Map<String, String> payload) {
        String audioDescription = payload.get("audioDescription");
        String audioServiceResponse = this.textToSpeachService.audioGenerationFunction.apply(audioDescription);
        log.info("Generated response: {}", audioServiceResponse);
        return Map.of("audioDescription", audioDescription, "response", audioServiceResponse);
    }
}

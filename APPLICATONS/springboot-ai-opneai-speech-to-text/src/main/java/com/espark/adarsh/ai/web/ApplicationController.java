package com.espark.adarsh.ai.web;

import com.espark.adarsh.ai.service.SpeechToTextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Slf4j
@RestController
public class ApplicationController {

    private SpeechToTextService speechToTextService;

    @PostMapping("/api/audio/transcript")
    public Map<String, Object> generateTranscribe(@RequestParam("audioFile") MultipartFile audioFile) {
        String audioServiceResponse = this.speechToTextService.generationAudoTranscriptFunction.apply(audioFile);
        log.info("Generated response: {}", audioServiceResponse);
        return Map.of("response", audioServiceResponse);
    }
}

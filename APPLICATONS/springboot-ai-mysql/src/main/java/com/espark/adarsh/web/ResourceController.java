package com.espark.adarsh.web;

import com.espark.adarsh.service.ResourceService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam String question) {
        log.info("Received question: {}", question);
        String response =  resourceService.processQuestion(question);
        log.info("Generated response: {}", response);
        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(response);
    }
}

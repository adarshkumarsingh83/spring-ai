package com.espark.adarsh.web;

import com.espark.adarsh.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Slf4j
@RestController
public class ImageController {


    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }


    @PostMapping(value = "/image", consumes = {"multipart/form-data"})
    public ResponseEntity<?> uploadAudioStream(@RequestParam("file") MultipartFile file, @RequestParam("message") String message) {

        if (file.isEmpty()) {
            log.info("Server info '{}'", "empty file");
            return ResponseEntity.badRequest().body("No file uploaded.");
        }
        try {
            InputStream inputStream = file.getInputStream();
            ChatResponse response = imageService.generate.apply(inputStream, message);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            log.error("Error processing file: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing file.");
        }
    }
}

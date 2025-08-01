package com.espark.adarsh.ai.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.ai.openai.audio.speech.SpeechPrompt;
import org.springframework.ai.openai.audio.speech.SpeechResponse;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

@Slf4j
@Service
public class TextToSpeachService {

    private OpenAiAudioSpeechOptions openAiAudioSpeechOptions;
    private OpenAiAudioSpeechModel openAiAudioSpeechModel;

    public TextToSpeachService(OpenAiAudioSpeechOptions openAiAudioSpeechOptions, OpenAiAudioSpeechModel openAiAudioSpeechModel) {
        this.openAiAudioSpeechOptions = openAiAudioSpeechOptions;
        this.openAiAudioSpeechModel = openAiAudioSpeechModel;
    }

    public final Function<String, String> audioGenerationFunction = (audioDescription) -> {
        log.info("Generating audio for description: {}", audioDescription);
        SpeechPrompt speechPrompt = new SpeechPrompt(audioDescription, openAiAudioSpeechOptions);
        SpeechResponse response = openAiAudioSpeechModel.call(speechPrompt);
        log.info("Generated audio response: {}", response);
        if (response == null || response.getResults() == null) {
            log.error("Failed to generate audio for description: {}", audioDescription);
            throw new RuntimeException("Audio generation failed");
        }
        log.info("Audio generation successful for description: {}", audioDescription);
        byte[] audioBytes = response.getResult().getOutput();

        if (audioBytes != null && audioBytes.length != 0) {
            File outputFile = new File("output_audio_" + System.currentTimeMillis() + ".mp3");
            try {
                outputFile.createNewFile();
                FileOutputStream fos = new FileOutputStream(outputFile);
                log.info("Writing audio to file: output_audio.mp3");
                fos.write(audioBytes);
                fos.close();
                log.info("Audio written to file successfully: {}", outputFile.getAbsolutePath());
                return "File Saved " + outputFile.getAbsolutePath();
            } catch (IOException e) {
                log.error("Error writing audio to file: {}", e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return "No audio data generated for description: " + audioDescription;
    };
}

package com.espark.adarsh.ai.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.audio.transcription.AudioTranscriptionResponse;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.function.Function;

@Slf4j
@Service
public class SpeechToTextService {

   private OpenAiAudioTranscriptionOptions openAiAudioSpeechOptions;
   private OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel;

   public SpeechToTextService(
           OpenAiAudioTranscriptionOptions openAiAudioSpeechOptions,
           OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel) {
       this.openAiAudioSpeechOptions = openAiAudioSpeechOptions;
       this.openAiAudioTranscriptionModel = openAiAudioTranscriptionModel;
   }


    public final Function<MultipartFile, String> generationAudoTranscriptFunction = (audioFile) -> {
        try {
            File tempFile = File.createTempFile("audio", ".wav");
            audioFile.transferTo(tempFile);
            log.info("Temporary file created at: {}", tempFile.getAbsolutePath());
            FileSystemResource fileSystemResource = new FileSystemResource(tempFile);
            AudioTranscriptionPrompt audioTranscriptionPrompt = new AudioTranscriptionPrompt(fileSystemResource,openAiAudioSpeechOptions);
            AudioTranscriptionResponse audioTranscriptionResponse = openAiAudioTranscriptionModel.call(audioTranscriptionPrompt);
            log.info("Transcription response: {}", audioTranscriptionResponse.getResult().getOutput());
            tempFile.delete();
            return audioTranscriptionResponse.getResult().getOutput();
        } catch (IOException e) {
            log.error( "Error processing audio file", e);
            throw new RuntimeException(e);
        }
    };
}

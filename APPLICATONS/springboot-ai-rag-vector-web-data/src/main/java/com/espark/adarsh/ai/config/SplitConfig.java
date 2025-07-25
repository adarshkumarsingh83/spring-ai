package com.espark.adarsh.ai.config;

import lombok.Data;

@Data
public class SplitConfig {

    int defaultChunkSize; //default 800
    int minChunkSizeChars ;
    int minChunkLengthToEmbed;
    int maxNumChunks;
    boolean keepSeparator;
}

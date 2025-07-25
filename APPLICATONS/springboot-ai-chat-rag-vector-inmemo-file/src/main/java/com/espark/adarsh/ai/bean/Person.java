package com.espark.adarsh.ai.bean;
import java.util.List;

public record Person (
     String name,
     String dataObBirth,
     String address,
     List<String> skills
){ }

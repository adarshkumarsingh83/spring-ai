package com.espark.adarsh.web;

import com.espark.adarsh.service.QueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class QueryController {

    public QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String query) {
        log.info("Received query: {}", query);
        String response = queryService.chat(query);
        log.info("Response: {}", response);
        return response;
    }
}
package com.espark.adarsh.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.mcp.server.autoconfigure.McpServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain jwtSecurityFilterChain(HttpSecurity http, McpServerProperties mcpServerProperties) throws Exception {
        log.info("SecurityConfiguration.jwtSecurityFilterChain() executed");
        http
                .authorizeHttpRequests((requests) ->
                        requests.requestMatchers(HttpMethod.GET, mcpServerProperties.getSseEndpoint()).hasAuthority("SCOPE_mcp")
                                .requestMatchers(HttpMethod.POST, mcpServerProperties.getSseMessageEndpoint()).hasAuthority("SCOPE_mcp")
                                .anyRequest().authenticated())
                .oauth2ResourceServer(
                        (resourceServer) ->
                                resourceServer.jwt(Customizer.withDefaults()));
        return http.build();
    }
}
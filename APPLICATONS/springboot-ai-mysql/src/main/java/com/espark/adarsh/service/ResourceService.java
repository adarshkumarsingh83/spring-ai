package com.espark.adarsh.service;

import com.espark.adarsh.config.SystemPrompt;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ResourceService {


    private SystemPrompt systemPrompt ;

    private final OllamaChatModel ollamaChatModel;
    private final JdbcTemplate jdbcTemplate;

    public ResourceService(OllamaChatModel ollamaChatModel, JdbcTemplate jdbcTemplate,SystemPrompt systemPrompt ) {
        this.ollamaChatModel = ollamaChatModel;
        this.jdbcTemplate = jdbcTemplate;
        this.systemPrompt=systemPrompt;
    }

    public String processQuestion(String question) {
     String  prompt = systemPrompt.getSystemPrompt().formatted(question);

        ChatResponse response = ollamaChatModel.call(new Prompt(prompt));
        String sql = cleanSql(response.getResult().getOutput().getText());

        System.out.println("Generated SQL:"+sql);
        if (!sql.trim().toLowerCase().startsWith("select")) {
            throw new IllegalArgumentException("Only SELECT queries are allowed.");
        }

        return executeQueryAndBuildHtml(sql);
    }

    private String cleanSql(String raw) {
        return raw.replaceAll("```sql", "")
                .replaceAll("```", "")
                .trim();
    }

    private String executeQueryAndBuildHtml(String sql) {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        if (rows.isEmpty()) {
            return "<p>No results found.</p>";
        }

        StringBuilder html = new StringBuilder("<table border='1'><tr>");
        for (String column : rows.get(0).keySet()) {
            html.append("<th style='background-color: #007BFF; color: white;'>").append(column).append("</th>");
        }
        html.append("</tr>");
        for (Map<String, Object> row : rows) {
            html.append("<tr style='background-color: yellow; color: black;'>");
            for (Object value : row.values()) {
                html.append("<td>").append(value != null ? value.toString() : "").append("</td>");
            }
            html.append("</tr>");
        }
        html.append("</table>");
        return html.toString();
    }
}

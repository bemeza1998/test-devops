package com.devops.bmeza.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Generated;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Generated
public class AuthEntryPointJwt implements AuthenticationEntryPoint {
    
    @Value("${app.api.key}")
    private  String API_KEY_HEADER;

    @Value("${app.api.key.value}")
    private  String VALID_API_KEY;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException)
            throws IOException, ServletException {

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        String apiKey = request.getHeader(API_KEY_HEADER);

        if (apiKey == null) {
            this.buildBody(response,
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Bad request",
                    "Missing X-Parse-REST-API-Key header",
                    request.getServletPath());
            return;
        } else if (!apiKey.equals(VALID_API_KEY)){
            this.buildBody(response,
            HttpServletResponse.SC_BAD_REQUEST,
            "Bad request",
            "Bad X-Parse-REST-API-Key value",
            request.getServletPath());
            return;
        }

        this.buildBody(response,
                HttpServletResponse.SC_UNAUTHORIZED,
                "Unauthorized",
                authException.getMessage(),
                request.getServletPath());

    }

    private void buildBody(HttpServletResponse response, int status, String error, String message, String path)
            throws StreamWriteException, DatabindException, IOException {
        Map<String, Object> body = new HashMap<>();
        body.put("status", status);
        body.put("error", error);
        body.put("message", message);
        body.put("path", path);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), body);
    }
}
package com.devops.bmeza.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor{

    private static final String API_KEY_HEADER_NAME = "X-Parse-REST-API-Key";
    private static final String VALID_API_KEY = "2f5ae96c-b558-4c7b-a590-a501ae1c3f6c";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String apiKey = request.getHeader(API_KEY_HEADER_NAME);

        if (VALID_API_KEY.equals(apiKey)) {
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }
    }
    
}

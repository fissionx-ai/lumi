package com.fissionx.lumi.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fissionx.lumi.mapper.ErrorResponseMapper;
import com.fissionx.lumi.utils.Status;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.annotations.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

    private static final String API_KEY_HEADER = "x-api-key";
    private static final String VALID_API_KEY = "your-valid-api-key";

    private final ObjectMapper mapper=new ObjectMapper();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String apiKey = request.getHeader(API_KEY_HEADER);

        // Check if the API key is present and valid
        if (apiKey == null || !apiKey.equals(VALID_API_KEY)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            String forbiddentRes=mapper.writeValueAsString( ErrorResponseMapper.getErrorResponse(Status.UNAUTHORIZED, HttpStatus.FORBIDDEN,"Forbidden: Invalid or missing API key" ));
            response.getWriter().write(forbiddentRes);
            return false;
        }

        return true;
    }
}
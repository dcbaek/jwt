package com.example.jwt.config.jwt;

public interface JwtProperties {
    String SECRET = "hanait1010";
    int EXPIRATION_TIME = 600;
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}

package com.example.jwt.config.jwt;

public interface JwtProperties {
    String SECRET = "조익현";
    int EXPIRATION_TIME = 864000000;
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}

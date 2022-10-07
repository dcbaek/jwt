package com.example.jwt.config.jwt;

import com.example.jwt.config.auth.PrincipalDetails;
import com.example.jwt.config.auth.PrincipalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final PrincipalDetailsService principalDetailsService;

    //출처:https://stackoverflow.com/questions/71281032/spring-security-exposing-authenticationmanager-without-websecurityconfigureradap
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        PrincipalDetails principalDetails = (PrincipalDetails) principalDetailsService.loadUserByUsername(authentication.getName());

        if (!bCryptPasswordEncoder.matches(authentication.getCredentials().toString(), principalDetails.getPassword())) {
            throw new BadCredentialsException("Wrong password!");
        }

        return new UsernamePasswordAuthenticationToken(principalDetails, null, principalDetails.getAuthorities());
    }
}
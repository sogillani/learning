package com.sog.spring.security.learnspringsecurity.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JwtUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UsernamePasswordRequest usernamePasswordRequest = new ObjectMapper().readValue(request.getInputStream(), UsernamePasswordRequest.class);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    usernamePasswordRequest.getUsername(),
                    usernamePasswordRequest.getPassword());

            Authentication authenticate = authenticationManager.authenticate(authentication);

            return authenticate;

        } catch(IOException e) {
            throw new RuntimeException();

        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String secret = "secretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecret";
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorties", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(3)))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();

        response.addHeader("Authorization", "Bearer " + token);
    }
}

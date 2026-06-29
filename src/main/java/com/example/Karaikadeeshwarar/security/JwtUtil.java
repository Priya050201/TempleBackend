package com.example.Karaikadeeshwarar.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private long expiration;

    private Key getKey() {
        System.out.println("SECRET = " + secret);
        System.out.println("LENGTH = " + secret.length());
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String username){

        return Jwts.builder()

                .subject(username)

                .issuedAt(new Date())

                .expiration(
                        new Date(
                                System.currentTimeMillis() + expiration
                        )

                )

                .signWith(getKey())

                .compact();
    }

    public String extractUsername(String token){

        return Jwts.parser()

                .verifyWith((javax.crypto.SecretKey) getKey())

                .build()

                .parseSignedClaims(token)

                .getPayload()

                .getSubject();
    }

    public boolean validateToken(String token,String username){

        return extractUsername(token).equals(username);
    }
}
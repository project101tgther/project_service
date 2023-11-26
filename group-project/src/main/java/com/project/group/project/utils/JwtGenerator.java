package com.project.group.project.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.project.group.project.constants.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

import static io.jsonwebtoken.Jwts.builder;

@Component
public class JwtGenerator {

    public String generateToken(Authentication authentication) {
        return Jwts.builder()
                .setSubject(authentication.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + SecurityConstants.JWT_EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET)
                .compact();
    }
}

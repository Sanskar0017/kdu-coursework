package com.kdu.smarthome.utils;

import com.kdu.smarthome.config.CustomAuthenticationManager;
import com.kdu.smarthome.dto.request.RegisterUserRequest;
import com.kdu.smarthome.filter.TokenGeneratorFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

/**
 * Utility class for JSON Web Token (JWT) operations.
 */
@Component
public class JWTUtil {
    private final CustomAuthenticationManager customAuthProvider;
    private final TokenGeneratorFilter tokenGeneratorFilter;

    @Autowired
    public JWTUtil(CustomAuthenticationManager customAuthProvider,
                   TokenGeneratorFilter tokenGeneratorFilter) {
        this.customAuthProvider = customAuthProvider;
        this.tokenGeneratorFilter = tokenGeneratorFilter;
    }

    /**
     * Create a JWT token for the provided user request.
     *
     * @param userRequestDTO The user registration request DTO.
     * @return The generated JWT token.
     */
    public String createToken(RegisterUserRequest userRequestDTO){
        Authentication authentication = customAuthProvider.authenticate(
                new UsernamePasswordAuthenticationToken(userRequestDTO.getUsername(), userRequestDTO.getPassword())
        );
        return tokenGeneratorFilter.generateJwt(authentication);
    }

    /**
     * Decode the provided JWT token and retrieve the username.
     *
     * @param token The JWT token to decode.
     * @return The username decoded from the token.
     */
    public String decodeToken(String token){
        String secretKey = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";

        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return String.valueOf(claims.get("username"));
    }
}

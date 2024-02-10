package com.kdu.smarthome.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * A filter for validating JWT tokens extracted from incoming HTTP requests.
 */


@Component
public class TokenValidatorFilter extends OncePerRequestFilter {

    public static final String JWT_HEADER = "Authorization";

    public static final String JWT_KEY = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String path = request.getRequestURI();
        if(path.equals("/api/v1/auth/register")){
            filterChain.doFilter(request, response);
            return;
        }
        String jwtWithBearer = request.getHeader(JWT_HEADER);
        if (jwtWithBearer != null) {
            try {
                String jwt = jwtWithBearer.substring(7);
                SecretKey key = Keys.hmacShaKeyFor(JWT_KEY.getBytes(StandardCharsets.UTF_8));
                Claims claims = Jwts.parser()
                        .verifyWith(key)
                        .build()
                        .parseSignedClaims(jwt)
                        .getPayload();

                String username = String.valueOf(claims.get("username"));
                String authorities = (String) claims.get("roles");
                Authentication auth = new UsernamePasswordAuthenticationToken(username, null,
                        AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (Exception e) {
                throw new BadCredentialsException("Invalid Token received!");
            }
        }
        else{
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid/Empty token");
            return;
        }
        filterChain.doFilter(request, response);
    }






    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getServletPath().equals("/api/v1/auth/register");
    }
}
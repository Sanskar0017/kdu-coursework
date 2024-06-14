package com.kdu.smarthome.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This filter generates a JWT token for authenticated users.
 */
@Component
public class TokenGeneratorFilter extends OncePerRequestFilter {
    /** The secret key used for JWT signing. */
    public static final String JWT_KEY = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";

    /** The name of the JWT header. */
    public static final String JWT_HEADER = "Authorization";

    /**
     * Generates a JWT token for authenticated users.
     *
     * @param request the HTTP servlet request
     * @param response the HTTP servlet response
     * @param filterChain the filter chain
     * @throws ServletException if a servlet exception occurs
     * @throws IOException if an I/O exception occurs
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication) {
            String jwt = generateJwt(authentication);
            response.setHeader(JWT_HEADER, jwt);
        }

        filterChain.doFilter(request, response);
    }

    public String generateJwt(Authentication authentication){
            SecretKey key = Keys.hmacShaKeyFor(JWT_KEY.getBytes(StandardCharsets.UTF_8));
            return Jwts.builder().issuer("kdu").subject("JWT Token")
                    .claim("username", authentication.getName())
                    .claim("roles", populateAuthorities(authentication.getAuthorities()))
                    .issuedAt(new Date())
                    .expiration(new Date((new Date()).getTime() + 30000000))
                    .signWith(key).compact();
        }

    /**
     * Determines whether the filter should be applied to the request.
     *
     * @param request the HTTP servlet request
     * @return true if the filter should not be applied, otherwise false
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getServletPath().equals("/person/login");
    }

    /**
     * Populates the authorities into a comma-separated string.
     *
     * @param collection the collection of granted authorities
     * @return a string representation of authorities
     */
    private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
        Set<String> authoritiesSet = new HashSet<>();
        for (GrantedAuthority authority : collection) {
            authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
    }
}

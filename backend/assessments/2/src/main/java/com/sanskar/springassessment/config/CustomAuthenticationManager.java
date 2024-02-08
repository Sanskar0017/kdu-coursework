package com.sanskar.springassessment.config;

import com.sanskar.springassessment.model.Person;
import com.sanskar.springassessment.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * CustomAuthenticationManager provides custom authentication logic for Spring Security.
 */
public class CustomAuthenticationManager implements AuthenticationProvider {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructor for CustomAuthenticationManager.
     * @param userService The UserService to interact with user data.
     * @param passwordEncoder The password encoder for encoding and matching passwords.
     */
    public CustomAuthenticationManager(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Person person = userService.getUser(username);

        if (person == null) {
            throw new BadCredentialsException("No user registered with this details!");
        } else {
            if (passwordEncoder.matches(pwd, person.getPassword())) {
                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(person.getRole()));
            } else {
                throw new BadCredentialsException("Invalid password!");
            }
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    /**
     * Get the granted authorities for the user role.
     * @param role The role of the user.
     * @return List of granted authorities.
     */
    private List<GrantedAuthority> getGrantedAuthorities(String role) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        return grantedAuthorities;
    }
}

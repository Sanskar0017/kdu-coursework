package com.kdu.smarthome.config;
import com.kdu.smarthome.models.Users;
import com.kdu.smarthome.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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
@Configuration
public class CustomAuthenticationManager implements AuthenticationProvider {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthenticationManager(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Users person = usersRepository.findByUsername(username);

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

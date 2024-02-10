package com.kdu.smarthome.config;

import com.kdu.smarthome.filter.TokenGeneratorFilter;
import com.kdu.smarthome.filter.TokenValidatorFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Configuration class for custom security settings.
 */
@Configuration
public class CustomSecurityConfig {

    /**
     * Configures custom security filters and authorization rules.
     *
     * @param http the HttpSecurity object to configure security settings
     * @return a SecurityFilterChain object representing the custom security filter chain
     * @throws Exception if configuration encounters an error
     */
    @Bean
    SecurityFilterChain customDefaultFilter(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new TokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new TokenValidatorFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> requests
                        .antMatchers("/person/login", "/api/v1/auth/register").permitAll()
                        .antMatchers("/user/**", "/search/user", "/user").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable);
        http.httpBasic(withDefaults());
        return http.build();
    }

    /**
     * Provides an implementation of the PasswordEncoder interface for password hashing.
     *
     * @return a PasswordEncoder object
     */

    @SuppressWarnings("deprecation")
    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}

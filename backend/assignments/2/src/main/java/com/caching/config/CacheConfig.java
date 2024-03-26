package com.caching.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;

/**
 * Configuration class for setting up Caffeine-based caching.
 */
@Configuration
@EnableCaching
public class CacheConfig {

    /**
     * Configures the Caffeine cache with maximum size and expiration time.
     *
     * @return Caffeine configuration object
     */
    @Bean
    public Caffeine<Object, Object> caffeineConfig() {
        return Caffeine.newBuilder()
                .maximumSize(100) // Increase maximum size according to your application's requirements
                .expireAfterAccess(30, TimeUnit.MINUTES);
    }

    /**
     * Configures the CaffeineCacheManager with cache names and Caffeine configuration.
     *
     * @return CacheManager implementation using Caffeine
     */
    @Bean
    public CacheManager caffeineCacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(caffeineConfig());
        caffeineCacheManager.setCacheNames(Arrays.asList("geocoding", "reverse-geocoding"));
        return caffeineCacheManager;
    }
}

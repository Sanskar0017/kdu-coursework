package com.caching.service;

import com.caching.exception.MappingParameterException;
import com.caching.util.ThirdPartyLocationAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Service class for handling geocoding operations.
 */
@Slf4j
@Service
public class GeoCodingService {

    @Autowired
    private ThirdPartyLocationAPI thirdPartyLocationAPI;

    @Value("${external.api.key}")
    private String apiKey;

    /**
     * Retrieves geocoding information for the provided address.
     * Caches the response based on the address.
     *
     * @param address The address for geocoding.
     * @return A ResponseEntity<String> indicating success or failure.
     */
    @Cacheable(value = "geocoding", key = "#address", unless = "#result.region.equalsIgnoreCase('Goa')")
    public ResponseEntity<String> getGeoCoding(String address) {
        if (address == null || address.isEmpty()) {
            throw new MappingParameterException("Address is null or empty.");
        }

        String result = thirdPartyLocationAPI.getLatLonWithAddress(address);
        if (!result.isEmpty()) {
            log.info("Geocoding information retrieved successfully for address: {}", address);
            return ResponseEntity.ok("Success: " + result);
        } else {
            log.error("Failed to retrieve geocoding information for address: {}", address);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failure: Unable to retrieve geocoding information for the provided address.");
        }
    }

    /**
     * Evicts the cache for the specified key.
     *
     * @param evictKey The key to evict from the cache.
     */
    @CacheEvict(value = "geocoding", key = "#evictKey")
    public void evictKey(String evictKey){
        log.info("Deletion of Cache at key : {}", evictKey);
    }
}

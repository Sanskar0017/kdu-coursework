package com.caching.service;

import com.caching.exception.MappingParameterException;
import com.caching.util.ThirdPartyLocationAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Service class for reverse geocoding operations.
 */
@Slf4j
@Service
public class ReverseGeoCodingService {

    @Autowired
    private ThirdPartyLocationAPI thirdPartyLocationAPI;

    /**
     * Retrieves reverse geocoding data for the given latitude and longitude.
     *
     * @param latitude  The latitude coordinate.
     * @param longitude The longitude coordinate.
     * @return ResponseEntity containing a String response indicating the reverse geocoding data.
     */
    @Cacheable(value = "reverse-geocoding", key = "{#latitude,#longitude}")
    public ResponseEntity<String> getReverseGeoCoding(String latitude, String longitude) {
        if (latitude == null || longitude == null || latitude.isEmpty() || longitude.isEmpty()) {
            throw new MappingParameterException("Latitude or Longitude is null or empty.");
        }

        String address = thirdPartyLocationAPI.getAddressWithLatLon(latitude, longitude);
        String responseMsg = "Reverse geocoding data for coordinates (" + latitude + ", " + longitude + "): " + address;

        log.info(responseMsg);
        return new ResponseEntity<>(responseMsg, HttpStatus.OK);
    }

    /**
     * Evicts the cache for the specified key.
     *
     * @param keyEvict The key to evict from the cache.
     */
    @CacheEvict(value = "reverse-geocoding", key = "#keyEvict")
    public void cacheEvict(String keyEvict) {
        log.info("Deletion of Cache at key: {}", keyEvict);
    }
}

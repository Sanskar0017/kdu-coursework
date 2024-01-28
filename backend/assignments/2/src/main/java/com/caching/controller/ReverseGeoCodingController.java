package com.caching.controller;

import com.caching.service.ReverseGeoCodingService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for reverse geocoding operations.
 * Handles requests related to converting latitude and longitude to an address.
 */
@Slf4j
@RestController
@Data
@AllArgsConstructor
public class ReverseGeoCodingController {

    @Autowired
    private ReverseGeoCodingService reverseGeoCodingService;

    /**
     * Performs reverse geocoding to retrieve the address from given latitude and longitude.
     *
     * @param latitude  The latitude coordinate for reverse geocoding.
     * @param longitude The longitude coordinate for reverse geocoding.
     * @return ResponseEntity containing the reverse geocoded address and other details.
     */
    @GetMapping("/reverse-geocoding")
    public ResponseEntity<String> getReverseGeoCoding(
            @RequestParam("latitude") String latitude,
            @RequestParam("longitude") String longitude) {
        log.info("Received request for reverse geocoding with latitude: {} and longitude: {}", latitude, longitude);

        String reverseGeoCodingResult = String.valueOf(reverseGeoCodingService.getReverseGeoCoding(latitude, longitude));
        HttpStatus status = reverseGeoCodingResult.startsWith("Error") ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK;

        log.info("Reverse geocoding result for latitude: {}, longitude: {}: {}", latitude, longitude, reverseGeoCodingResult);

        return new ResponseEntity<>(reverseGeoCodingResult, status);
    }
}

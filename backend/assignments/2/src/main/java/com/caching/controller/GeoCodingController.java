package com.caching.controller;

import com.caching.service.GeoCodingService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling GeoCoding requests.
 */
@Slf4j
@RequestMapping
@RestController
@Data
@AllArgsConstructor
public class GeoCodingController {

    /**
     * Service for handling GeoCoding operations.
     */
    @Autowired
    private GeoCodingService geoCodingService;

    /**
     * Retrieves the GeoCoding information for the given address.
     *
     * @param address The address for which GeoCoding information is requested.
     * @return ResponseEntity containing the GeoCodingResponse and HTTP status.
     */
    @GetMapping("/geocoding")
    public ResponseEntity<String> getGeoCoding(@RequestParam("address") String address){
        log.info("Received request for GeoCoding with address: {}", address);
        GeoCodingService geoCodingService = new GeoCodingService();
        String result = String.valueOf(geoCodingService.getGeoCoding(address));
        log.info("GeoCoding result for address '{}': {}", address, result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

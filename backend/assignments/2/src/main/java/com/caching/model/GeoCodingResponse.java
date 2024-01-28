package com.caching.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents the response for geocoding operations.
 */
@Data
@AllArgsConstructor
public class GeoCodingResponse {

    /**
     * Latitude coordinate of the location.
     */
    private String lat;

    /**
     * Longitude coordinate of the location.
     */
    private String lon;
}

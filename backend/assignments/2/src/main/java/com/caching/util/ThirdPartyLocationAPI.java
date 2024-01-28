package com.caching.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;


/**
 * Service class to interact with third-party location APIs.
 */
@Slf4j
@Service
public class ThirdPartyLocationAPI {

    /**
     * Retrieves latitude and longitude for a given address.
     *
     * @param address The address to fetch latitude and longitude for.
     */


    public static String getLatLonWithAddress(String address) {
        try {
            String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8);
            String apiUrl = "https://geocode.maps.co/search?q=" + encodedAddress + "&api_key=65b3602db1f81129223658jwv85146a";

            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                HttpGet request = new HttpGet(apiUrl);
                try (CloseableHttpResponse response = httpClient.execute(request)) {
                    int statusCode = response.getStatusLine().getStatusCode();
                    String contentType = response.getEntity().getContentType().getValue();
                    String jsonResponse = EntityUtils.toString(response.getEntity());

                    log.info("Response Status Code: " + statusCode);
                    log.info("Content Type: " + contentType);
                    log.info("Response Body: " + jsonResponse);

                    if (statusCode == 200 && contentType.contains("application/json")) {
                        ObjectMapper objectMapper = new ObjectMapper();
                        JsonNode rootNode = objectMapper.readTree(jsonResponse);
                        if (!rootNode.isEmpty()) {
                            JsonNode firstResult = rootNode.get(0);
                            double latitude = Optional.ofNullable(firstResult.get("lat")).map(JsonNode::asDouble).orElse(Double.NaN);
                            double longitude = Optional.ofNullable(firstResult.get("lon")).map(JsonNode::asDouble).orElse(Double.NaN);

                            if (!Double.isNaN(latitude) && !Double.isNaN(longitude)) {
                                log.info("Latitude: " + latitude);
                                log.info("Longitude: " + longitude);
                                return "Latitude: " + latitude + ", Longitude: " + longitude;
                            } else {
                                log.error("Latitude or Longitude not found in response");
                                return "Latitude or Longitude not found in response";
                            }
                        } else {
                            log.error("Invalid or empty response format");
                            return "Invalid or empty response format";
                        }

                    } else {
                        log.error("Error Response: " + jsonResponse);
                        return "Error Response: " + jsonResponse;
                    }
                }
            }
        } catch (Exception e) {
            log.error("Error fetching latitude and longitude: " + e.getMessage(), e);
            return "Error fetching latitude and longitude: " + e.getMessage();
        }
    }


    /**
     * Extracts the address from the JSON response.
     *
     * @param jsonResponse The JSON response from the API.
     * @return The extracted address.
     */
    public static String extractAddress(String jsonResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            if (rootNode.has("address")) {
                JsonNode addressNode = rootNode.get("address");
                String county = addressNode.has("county") ? addressNode.get("county").asText() : "";
                String stateDistrict = addressNode.has("state_district") ? addressNode.get("state_district").asText() : "";
                String state = addressNode.has("state") ? addressNode.get("state").asText() : "";
                String country = addressNode.has("country") ? addressNode.get("country").asText() : "";
                return county + ", " + stateDistrict + ", " + state + ", " + country;
            } else {
                return "Address key not found in response";
            }
        } catch (Exception e) {
            log.error("Error extracting address: " + e.getMessage(), e);
            return "Error extracting address: " + e.getMessage();
        }
    }

    /**
     * Retrieves the address for a given latitude and longitude.
     *
     * @param latitude  The latitude coordinate.
     * @param longitude The longitude coordinate.
     * @return The address corresponding to the provided latitude and longitude.
     */
    public static String getAddressWithLatLon(String latitude, String longitude) {
        try {
            String apiKey = "65b3602db1f81129223658jwv85146a";
            String apiUrl = "https://geocode.maps.co/reverse?lat=" + latitude + "&lon=" + longitude + "&apiKey=" + apiKey;

            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                HttpGet request = new HttpGet(apiUrl);
                try (CloseableHttpResponse response = httpClient.execute(request)) {
                    int statusCode = response.getStatusLine().getStatusCode();
                    String jsonResponse = EntityUtils.toString(response.getEntity());

                    String address = extractAddress(jsonResponse);
                    log.info("Address: {}", address);

                    if (statusCode == 200) {
                        return address;
                    } else {
                        return "Error fetching address - Status code: " + statusCode;
                    }
                }
            }
        } catch (IOException e) {
            log.error("Error fetching address: {}", e.getMessage(), e);
            return "Error fetching address: " + e.getMessage();
        }
    }
}

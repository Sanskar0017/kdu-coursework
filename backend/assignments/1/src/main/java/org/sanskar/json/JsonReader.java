package org.sanskar.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Logger;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;

public class JsonReader {

    private static Logger LOGGER = Logger.getLogger(JsonReader.class.getName());

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    public static JsonNode readJsonFile(String filePath) throws IOException {
        File jsonFile = new File(filePath);

        if (!jsonFile.exists()) {
            LOGGER.info("File does not exist: " + filePath);
            return null;
        }

        try {
            String jsonContent = new String(Files.readAllBytes(jsonFile.toPath()));

            if (objectMapper == null) {
                // Handle the case where objectMapper is not initialized
                System.out.println("ObjectMapper not initialized");
                return null;
            }

            return objectMapper.readTree(jsonContent);
        } catch (IOException e) {
            LOGGER.info("Error reading file: " + filePath);
            e.printStackTrace();
            return null;
        }
    }
}

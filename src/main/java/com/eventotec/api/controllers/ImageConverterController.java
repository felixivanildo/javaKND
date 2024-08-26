package com.eventotec.api.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/images")
public class ImageConverterController {

    @Value("${redmine.api.url}")
    private String apiUrl;

    @PostMapping("/convertImage")
    public ResponseEntity<?> convertImage(@RequestBody Map<String, String> request) {

        // System.out.println(request);

        String dataUri = request.get("image");

        String base64Image = dataUri.split(",")[1]; // Get the part after the comma

        // Clean up and ensure padding
        base64Image = base64Image.replaceAll("[^A-Za-z0-9+/=]", ""); // Remove any illegal characters

        // Add padding if needed
        int length = base64Image.length();
        int padding = (4 - (length % 4)) % 4;
        if (padding > 0) {
            base64Image += "=".repeat(padding);
        }

        // Decode the Base64 string to bytes
        try {

           


            byte[] imageBytes = Base64.getDecoder().decode(base64Image);

            
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/octet-stream");

            // Wrap the byte array in an HttpEntity
            HttpEntity<byte[]> requestEntity = new HttpEntity<>(imageBytes, headers);

            // Send the byte array as a POST request
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, requestEntity, String.class);

            // Return a success response
            return ResponseEntity.ok((response.getBody()));
            // Use the byte array as needed
            // System.out.println(imageBytes);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
            // System.err.println("Invalid Base64 string: " + e.getMessage());
        }
        
    }
}
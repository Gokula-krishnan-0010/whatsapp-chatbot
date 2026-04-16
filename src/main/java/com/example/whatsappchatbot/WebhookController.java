package com.example.whatsappchatbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class WebhookController {
    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    @PostMapping
    public ResponseEntity<Map<String, String>> receiveMessage(@RequestBody Map<String, Object> payload) {
        // Log the incoming message
        logger.info("Received webhook payload: {}", payload);

        // Extract the text field (adjust based on actual WhatsApp payload structure)
        String text = (payload.get("text") != null) ? payload.get("text").toString() : "";
        String reply;
        switch (text.trim().toLowerCase()) {
            case "hi":
                reply = "Hello";
                break;
            case "bye":
                reply = "Goodbye";
                break;
            default:
                reply = "I didn't understand that message.";
        }
        // Respond with JSON containing the reply
        return ResponseEntity.ok(Map.of("reply", reply));
    }
}

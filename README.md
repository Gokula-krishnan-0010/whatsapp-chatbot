# WhatsApp Chatbot Simulation

A simple Spring Boot backend that mimics a WhatsApp chatbot webhook. It exposes a single REST endpoint to receive messages and respond with predefined replies.

## Project Structure
```
.
├── pom.xml
├── src
│   └── main
│       └── java
│           └── com
│               └── example
│                   └── whatsappchatbot
│                       ├── WhatsAppChatbotApplication.java   # Spring Boot entry point
│                       └── WebhookController.java           # /webhook endpoint
└── README.md
```

## Prerequisites
- Java 21 (or newer) installed
- Maven 3.9+ installed
- An internet connection to download dependencies the first time you build

## Build the project
```bash
# From the project root directory
mvn clean package
```
This will compile the sources and package the application into a runnable JAR under `target/`.

## Run the application
```bash
# Using Maven's spring‑boot plugin (recommended for development)
mvn spring-boot:run
```
or run the JAR directly:
```bash
java -jar target/whatsapp-chatbot-0.0.1-SNAPSHOT.jar
```
The server starts on **port 8080** by default.

## API Endpoint
### `POST /webhook`
Accepts a JSON payload representing a WhatsApp message. The JSON should contain a field named `text` with the message body. The service logs the incoming payload and returns a JSON response with a `reply` field.

#### Request example (using `curl`)
```bash
curl -X POST http://localhost:8080/webhook \
     -H "Content-Type: application/json" \
     -d '{"text": "Hi"}'
```
#### Successful response
```json
{ "reply": "Hello" }
```

The endpoint supports the following simple mappings:
| Incoming `text` | Reply |
|-----------------|-------|
| `Hi` (case‑insensitive) | `Hello` |
| `Bye` (case‑insensitive) | `Goodbye` |
| anything else | `I didn't understand that message.` |

### Logging
All incoming payloads are logged at INFO level using SLF4J. You can view the logs in the console output where the application is running.

## Development
- Change the message mappings by editing `WebhookController.java`.
- The project uses Spring Boot 3.2.5 and Java 21; adjust the Java version in `pom.xml` if you need a different JDK.
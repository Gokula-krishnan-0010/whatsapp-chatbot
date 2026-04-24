# WhatsApp Chatbot Simulation

A simple Spring Boot application that mimics a WhatsApp chatbot webhook. It provides a REST endpoint to receive messages and a web-based simulator for interactive testing.

## Project Structure
```
.
├── pom.xml
├── Dockerfile
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── whatsappchatbot
│       │               ├── WhatsAppChatbotApplication.java   # Spring Boot entry point
│       │               └── WebhookController.java           # /webhook endpoint
│       └── resources
│           └── static
│               └── index.html                       # Chat Simulator Frontend
└── README.md
```

## Prerequisites
- Java 21 (or newer) installed
- Maven 3.9+ installed
- Docker (optional, for containerized execution)

## Build the project
```bash
# From the project root directory
mvn clean package
```
This will compile the sources and package the application into a runnable JAR under `target/`.

## Run the application
### Locally
```bash
# Using Maven's spring-boot plugin
mvn spring-boot:run
```
The server starts on **port 8080** by default.

### Using Docker
```bash
docker build -t whatsapp-chatbot .
docker run -p 8080:8080 whatsapp-chatbot
```

## Usage

### Web Interface (Simulator)
Once the application is running, open your browser and navigate to:
**[http://localhost:8080](http://localhost:8080)**

The chat simulator allows you to:
1. Type messages in the input area.
2. Send messages by clicking the arrow icon or pressing `Enter`.
3. View the bot's automated responses in real-time.

### API Endpoint
#### `POST /webhook`
Accepts a JSON payload with a `text` field.

**Request example:**
```bash
curl -X POST http://localhost:8080/webhook \
     -H "Content-Type: application/json" \
     -d '{"text": "Hi"}'
```

**Response example:**
```json
{ "reply": "Hello" }
```

### Supported Commands
| Message | Response |
|---------|----------|
| `Hi` | `Hello` |
| `Bye` | `Goodbye` |
| *Other* | `I didn't understand that message.` |

## Development
- **Backend logic:** Modify `WebhookController.java` to change responses or logic.
- **Frontend UI:** Edit `src/main/resources/static/index.html` to update the simulator's look and feel.
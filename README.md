# The API Bridge

## Overview

The API Bridge connects a legacy system's data output to modern communication platforms like Slack and email. It features an AI-driven data extraction layer powered by Grok AI to intelligently parse and structure raw text for seamless integration.

## Features

- **AI-Powered Data Extraction**: Uses Grok AI to extract structured data (company name, date, total amount) from unstructured text.
- **Email Integration**: Sends extracted data to any email address.
- **Slack Integration**: Sends extracted data to a configured Slack channel.
- **RESTful API**: Exposes endpoints for both database-driven and AI-driven data sending.
- **Containerized**: Includes a `Dockerfile` for easy deployment and scaling.
- **Clean Architecture**: Follows a pragmatic Layered Architecture for maintainability and testability.

## Project Documentation References

This project is guided by three key documentation files located in the parent directory:

- **OFFICIAL_README.txt**  
  _Describes the overall technical and business goals, architecture principles (Clean/Hexagonal), and the AI-driven data extraction approach. It details the intended stack, modularity, and integration focus._

- **Future-Projects.txt**  
  _Lists the broader portfolio vision. For this project, it defines "Project B(The Bridge)" as connecting a legacy SQL database to a Slack bot for real-time operational alerts, showcasing integration skills._

- **Plan_Context.txt**  
  _Provides the business outreach narrative and context—who the solution is for, the pain points addressed, and how the project is positioned for real-world value._

**Refer to these files for the project's business case, technical standards, and future roadmap.**

---

## Architectural Principles

This project follows a **Layered Architecture**, a well-established pattern that aligns with the goals of Clean Architecture. While not a strict implementation of Clean Architecture, it respects the same principles of creating organized, decoupled, and testable code.

### Principles Followed

*   **Separation of Concerns**: The project is clearly divided into layers:
    *   **Controllers (Interface Adapters)**: Handle web requests and delegate to services.
    *   **Services (Use Cases)**: Contain the core application and business logic.
    *   **Repositories (Gateways)**: Abstract data access.
    *   **Models/DTOs (Entities/Data Structures)**: Represent the data.
*   **One-Way Dependency**: The dependency flow is correct for a layered architecture: `Controllers` -> `Services` -> `Repositories`. An inner layer like a service does not depend on an outer layer like a controller.

### Differences from Strict Clean Architecture

*   **The Dependency Rule**: A strict Clean Architecture mandates that all dependencies point *inward* toward the core business logic (Entities and Use Cases), which should have **zero dependencies on frameworks**.
    *   In this project, the inner layers have dependencies on frameworks. For example:
        *   The `Extraction` model (`@Entity`) depends on `jakarta.persistence`.
        *   The services (`@Service`, `@Autowired`) depend on the Spring Framework.
*   **Framework-Agnostic Core**: The core logic (services and models) is not independent of the web and database frameworks. A strict Clean Architecture would use interfaces in the core layer, with implementations (like Spring Data JPA repositories) in an outer layer, inverting the dependency.

### Conclusion

The project uses a **pragmatic and effective Layered Architecture**, which is the standard for Spring Boot applications. It successfully separates concerns and creates a maintainable structure.

## Prerequisites

- Java 17
- Maven 3.8+
- Docker (for containerization)
- A valid Grok AI API key

## Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd Project_2
```

### 2. Configure the Application

Open `src/main/resources/application.properties` and configure the following:

- **Grok AI**: Set your API key.
  ```properties
  groq.api.key=YOUR_GROQ_API_KEY
  ```
- **Email**: Configure your SMTP server details.
  ```properties
  spring.mail.host=smtp.example.com
  spring.mail.port=587
  spring.mail.username=your@email.com
  spring.mail.password=yourpassword
  ```
- **Slack**: Set your Slack webhook URL.
  ```properties
  slack.webhook.url=https://hooks.slack.com/services/your/webhook/url
  ```

### 3. Build and Run

#### Option A: Run with Maven

```bash
mvn spring-boot:run
```

#### Option B: Run with Docker

First, build the project JAR:
```bash
mvn clean package -DskipTests
```

Then, build and run the Docker container:
```bash
docker build -t apibridge:latest .
docker run -d -p 8080:8080 --name apibridge-app apibridge:latest
```

The application will be available at `http://localhost:8080`.

## Running Tests

To run the full test suite, execute:

```bash
mvn test
```

## API Documentation
 
 Interactive API documentation is available via Swagger UI. This allows you to explore endpoints and test requests directly from your browser.
 
 - **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
 - **OpenAPI JSON**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)
 
 For implementation details, see `PLAN.md` and the source code in this directory.

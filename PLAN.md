# PLAN.md

## Project: The API Bridge

### Goal
Connect a legacy system (CSV/SQL) to modern tools (Slack, Notion, Discord) by sending extracted results from Project_1 directly to a client's email or Slack channel.

### Value
Demonstrate integration of old software outputs with new communication platforms, bridging business data to actionable channels.

### Technology Stack (inherited from Project_1)
- **Language**: Java
- **Framework**: Spring Boot
- **Database**: H2 (in-memory, can extend to SQL)
- **Build Tool**: Maven/Gradle (as per Project_1)
- **Testing**: JUnit

### Coding Style
- Use the same package, class, and method conventions as Project_1.
- DTOs, Service, Controller layers.
- Dependency injection via Spring annotations.
- Exception handling and logging as in Project_1.

### High-Level Architecture
1. **Input**: Extracted results from Project_1 (via API or DB access).
2. **Processing**: Format results for delivery.
3. **Output**: Send results to:
    - Email (via SMTP, e.g., JavaMailSender)
    - Slack (via Slack API)

### Steps
- [x] Analyze Project_1 output format (DTO: ExtractionResponse).
- [x] Implement a service to fetch recent extractions.
- [x] Implement an email sender service.
- [x] Implement a Slack sender service.
- [x] Expose endpoints to trigger sending (POST: send-to-email, send-to-slack).
- [x] Configuration for email/Slack credentials.
- [x] Mock email and Slack integrations for local/testing.
- [x] Use numeric types (Double) for totals (totalAmount) in model and DTO.
- [x] Rerun tests with numeric types.
- [x] Add AI integration layer/service (real or simulated LLM call).
- [x] Improve error handling (custom exceptions, global handler).
- [x] Add API documentation (Swagger/OpenAPI).
- [x] Add Dockerfile for containerization.
- [x] Final testing and validation.

### Stretch Goals
- Add Notion/Discord integration.
- Schedule automatic sending (Spring Scheduler).
- UI for manual triggering (optional).

### Next Actions
- [x] Confirm Project_1 output integration method (DB/API).
- [x] Implement sender services.
- [x] Expose REST endpoints.
- [x] Add configuration and docs.
- [x] Mock email and Slack integrations.
- [x] Rerun endpoint tests with numeric types.
- [x] Implement and test AI integration layer.
- [x] Add/improve error handling.
- [x] Add API documentation (Swagger/OpenAPI).
- [x] Add Dockerfile and test containerization.

### Phase 4: Security & Upload (Detailed in UPLOAD-PLAN.md)
- [x] Implement Environment Variable Strategy (AIService, Email, Slack).
- [x] Migrate configuration to `application.yml`.
- [x] Secure Git History (check logs, update .gitignore).
- [ ] Execute Promotional Video Plan and Polish Repository.
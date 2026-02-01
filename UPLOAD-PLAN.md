# UPLOAD-PLAN.md

## Phase 1: Security & Configuration (Must-Do before Upload)
- [x] **Implement Environment Variable Strategy**
    - [x] Modify `AIService.java` to use `@Value("${ai.api.key}")` instead of hardcoded strings.
    - [x] Verify `EmailSenderService` and `SlackSenderService` also use `@Value` for credentials.
- [x] **Migrate Configuration**
    - [x] Create `src/main/resources/application.yml`.
    - [x] Port all settings from `application.properties` to YAML format.
    - [x] Delete `application.properties`.
- [x] **Secure Git History**
    - [x] Update `.gitignore` to strictly exclude `.env`, `application-secret.yml`, and any local config files.
    - [x] Check `git log` to ensure no keys were previously committed. (If yes, use `bfg` or `git filter-repo` to clean history).

## Phase 2: Promotional Video Production
*Based on `Promo-VIDEO` script*

### Pre-Production (Asset Prep)
- [ ] **Scene 1 Artifact**: Create a "messy" text file or mock email screenshot containing:
    > "Dear John, please find attached the billing for the transport from Florida to Montevideo. The total is $2,450.50 for Acme Corp, dated Jan 20..."
- [ ] **Scene 2 Setup (The Solution)**:
    - [ ] Open **Swagger UI** (`http://localhost:8080/swagger-ui.html`) or Postman.
    - [ ] Pre-fill the `/api/send/ai/extract` endpoint with the messy text.
    - [ ] *Suggestion*: Using Swagger UI shows off your documentation skills!
- [ ] **Scene 3 Setup (The Result)**:
    - [ ] Open the Slack channel where notifications arrive.
    - [ ] Open the email inbox.
    - [ ] Ensure the previous "test" messages are cleared for a clean look.

### Production
- [ ] **Record Scene 1 (0:00-0:15)**: Screen record the "Problem" (messy text).
- [ ] **Record Scene 2 (0:15-0:40)**: Record the "Action" (Clicking Execute/Send and expanding the JSON response).
- [ ] **Record Scene 3 (0:40-0:50)**: Record the "Notification" appearing in Slack/Email.
- [ ] **Record Scene 4 (0:50-1:00)**: Record the closing shot (LinkedIn/GitHub Profile).

## Phase 3: Strategic Polish (Maximize Market Impact)
- [ ] **Repository "Curb Appeal"**
    - [ ] Add a `LICENSE` file (MIT or Apache 2.0).
    - [ ] Create a `CONTRIBUTING.md` (even if simple, it shows professionalism).
    - [ ] Add a "Social Preview" image in GitHub settings (screenshot of the architecture diagram or Swagger UI).
- [ ] **Video Thumbnail**
    - [ ] Create a thumbnail text: "Java & AI Automation: The API Bridge".
    - [ ] Use a clean background with the Spring Boot + OpenAI/Grok logos.

## Phase 4: Final Upload
- [ ] Run `mvn clean` to remove `target/` directory.
- [ ] Commit all final changes.
- [ ] Push to GitHub.
- [ ] Verify the repository looks clean (no sensitive data).

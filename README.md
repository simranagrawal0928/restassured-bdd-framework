# REST Assured BDD Framework

API test automation framework built with REST Assured and Cucumber (BDD), targeting a local mock REST API server.

## Tech Stack

| Tool | Purpose |
|---|---|
| Java 17 | Language |
| Gradle (Kotlin DSL) | Build tool |
| REST Assured 5.4 | HTTP client / assertion library |
| Cucumber 7 | BDD layer (Gherkin scenarios) |
| JUnit 4 | Test runner |
| Jackson Databind | JSON ↔ POJO serialisation |
| Hamcrest | Matchers for assertions |
| PicoContainer | Dependency injection between step classes |

## Project Structure

```
src/test/
├── java/org/example/
│   ├── context/          # TestContext — shared state per scenario
│   ├── hooks/            # Cucumber @Before/@After hooks
│   ├── pojo/             # Jackson POJOs (User, Address, TokenResponse…)
│   ├── runner/           # JUnit TestRunner
│   ├── stepdefinitions/  # Step def classes (Common, User, Auth, Echo)
│   └── utils/            # ConfigReader, RestAssuredSetup
└── resources/
    ├── config.properties # Base URL config
    └── features/         # Gherkin feature files
        ├── user_crud.feature
        ├── auth.feature
        └── echo.feature
```

## Mock Server

Tests run against a local Python mock server. Clone and start it before running tests:

```bash
git clone git@github.com:simranagrawal0928/api-mock-server.git
cd api-mock-server
python3 server.py
```

Server runs at `http://127.0.0.1:8000`. Restart it before each test run to reset seed data.

## Running Tests

```bash
./gradlew test
```

HTML report generated at: `target/cucumber-reports/report.html`

## Feature Coverage

| Feature | Scenarios |
|---|---|
| User CRUD | GET all, GET by ID, POST, PUT, PATCH, DELETE, 404 cases |
| Authentication | Get token, validate valid/invalid token, missing header |
| Echo | Plain echo, authenticated echo, unauthenticated echo |

## Key Design Decisions

- **PicoContainer DI** — `TestContext` injected into all step classes so `Response` and `token` are shared across steps within a scenario without static state.
- **POJOs over JsonPath strings** — Responses deserialised into typed objects for readable assertions.
- **Config-driven base URL** — `config.properties` keeps the base URL out of test code.
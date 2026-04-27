plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // REST Assured — makes HTTP calls (GET/POST/PUT/PATCH/DELETE) and assertions easy
    testImplementation("io.rest-assured:rest-assured:5.4.0")

    // Cucumber Java — maps Gherkin steps (Given/When/Then) to Java @Step methods
    testImplementation("io.cucumber:cucumber-java:7.15.0")

    // Cucumber JUnit — lets JUnit 4 discover and run .feature files
    testImplementation("io.cucumber:cucumber-junit:7.15.0")

    // Cucumber PicoContainer — injects shared state (TestContext) into step def classes
    testImplementation("io.cucumber:cucumber-picocontainer:7.15.0")

    // JUnit 4 — Cucumber's @RunWith runner requires JUnit 4
    testImplementation("junit:junit:4.13.2")

    // Jackson — converts JSON <-> Java objects (POJOs)
    // e.g. response.as(User.class) turns {"name":"Alice"} into a User object
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")

    // Hamcrest — fluent assertion matchers (equalTo, hasItems, notNullValue, etc.)
    testImplementation("org.hamcrest:hamcrest:2.2")
}

tasks.test {
    // JUnit 4 runner (not JUnit 5 Platform) — needed for Cucumber @RunWith
    useJUnit()

    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
}
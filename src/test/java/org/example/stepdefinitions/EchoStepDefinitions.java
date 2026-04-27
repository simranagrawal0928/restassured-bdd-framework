package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.example.context.TestContext;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;

public class EchoStepDefinitions {
    private final TestContext context;

    public EchoStepDefinitions(TestContext context) {
        this.context = context;
    }

    @When("I send POST {string} with body:")
    public void iSendPostWithBody(String path, String body) {
        context.setResponse(
                given().contentType(ContentType.JSON).body(body).when().post(path));
    }

    @When("I send an authenticated POST to {string} with body:")
    public void iSendAuthenticatedPost(String path, String body) {
        context.setResponse(
                given().contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + context.getToken()).body(body)
                        .when().post(path));
    }

    @When("I send POST {string} without auth with body:")
    public void iSendPostWithoutAuth(String path, String body) {
        context.setResponse(
                given().contentType(ContentType.JSON).body(body).when().post(path));
    }

    @Then("the response field {string} should be {string}")
    public void theResponseFieldShouldBe(String field, String expectedValue) {
        context.getResponse().then().body(field, equalTo(expectedValue));
    }

    @Then("the response should contain a timestamp")
    public void theResponseShouldContainATimestamp() {
        context.getResponse().then().body("timestamp", notNullValue());
    }

}


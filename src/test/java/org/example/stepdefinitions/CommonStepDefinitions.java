package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.context.TestContext;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CommonStepDefinitions {
    private final TestContext context;

    public CommonStepDefinitions(TestContext context){
        this.context = context;
    }

    @When("I send GET {string}")
    public void isSendGet(String path) {
        context.setResponse(given().when().get(path));
    }

    @When("I send DELETE {string}")
    public void isSendDelete(String path) {
        context.setResponse(given().when().delete(path));
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int expectedStatus) {
        context.getResponse().then().statusCode(expectedStatus);
    }

    @Then("the error should be {string}")
    public void theErrorShouldBe(String expectedError){
        context.getResponse().then().body("error", equalTo(expectedError));
    }

}

package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.context.TestContext;
import org.example.pojo.TokenResponse;
import org.example.pojo.TokenValidationResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AuthStepDefinitions {

    private final TestContext context;

    public AuthStepDefinitions(TestContext context) {
        this.context = context;
    }

    @When("I request a new token")
    public void iRequestANewToken(){
        context.setResponse(given().when().post("/auth/token"));
    }

    @Given("I have obtained a valid token")
    public void iHaveObtainedAValidToken() {
        String token = given().when().post("/auth/token").then()
                .statusCode(201).extract().path("token");
        context.setToken(token);
    }

    @When("I validate the token")
    public void iValidateTheToken() {
        context.setResponse(given().header("Authorization","Bearer " + context.getToken())
                .when().get("/auth/validate"));
    }

    @When("I validate the token without an auth header")
    public void iValidateTheTokenWithoutAnAuthHeader() {
        context.setResponse(given().when().get("/auth/validate"));
    }

    @When("I validate the token with an invalid bearer")
    public  void iValidateTheTokenWithAnInvalidBearer() {
        context.setResponse(given().header("Authorization", "Bearer invalid-token")
                .when().get("/auth/validate"));
    }

    @Then("the response should contain a token")
    public void theResponseShouldContainAToken() {
        TokenResponse tokenResponse = context.getResponse().as(TokenResponse.class);
        assertThat(tokenResponse.getToken(), notNullValue());
        assertThat(tokenResponse.getToken(), not(emptyString()));
    }

    @Then("the token expires_in should be {int}")
    public void theTokenExpiresInShouldBe(int expectedSeconds) {
        TokenResponse tokenResponse = context.getResponse().as(TokenResponse.class);
        assertThat(tokenResponse.getExpiresIn(), equalTo(expectedSeconds));
    }

    @Then("the token should be valid")
    public void theTokenShouldBeValid() {
        TokenValidationResponse validation = context.getResponse().as(TokenValidationResponse.class);
        assertThat(validation.isValid(), equalTo(true));
    }

    @Then("the token should not be valid")
    public void theTokenShouldNotBeValid() {
        TokenValidationResponse validation = context.getResponse().as(TokenValidationResponse.class);
        assertThat(validation.isValid(), equalTo(false));
    }

}

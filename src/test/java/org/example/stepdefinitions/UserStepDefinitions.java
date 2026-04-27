package org.example.stepdefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.example.context.TestContext;
import org.example.pojo.CreateUserRequest;
import org.example.pojo.User;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserStepDefinitions {

    private final TestContext context;

    public UserStepDefinitions(TestContext context){
        this.context = context;
    }

    @Then("the response should contain {int} users")
    public void theResponseShouldContainUsers(int count) {
        context.getResponse().then().body("size()", equalTo(count));
    }

    @Then("the user name should be {string}")
    public void theUserNameShouldBe(String expectedName) {
        User user = context.getResponse().as(User.class);
        assertThat(user.getName(), equalTo(expectedName));
    }

    @Then("the user email should be {string}")
    public void theUserEmailShouldBe(String expectedEmail) {
        User user = context.getResponse().as(User.class);
        assertThat(user.getEmail(), equalTo(expectedEmail));
    }

    @Then("the user active status should be {string}")
    public void theUserActiveStatusShouldBe(String expectedActive) {
        User user = context.getResponse().as(User.class);
        assertThat(user.isActive(), equalTo(Boolean.parseBoolean(expectedActive)));
    }

    @Then("the user address city should be {string}")
    public void theUserAddressCityShouldBe(String expectedCity) {
        User user = context.getResponse().as(User.class);
        assertThat(user.getAddress().getCity(), equalTo(expectedCity));
    }

    @Then("the user phone should be null")
    public void theUserPhoneShouldBeNull() {
        User user = context.getResponse().as(User.class);
        assertThat(user.getPhone(), nullValue());
    }

    @Then("the user age should be {int}")
    public void theUserAgeShouldBe(int expectedAge) {
        User user = context.getResponse().as(User.class);
        assertThat(user.getAge(), equalTo(expectedAge));
    }

    @When("I create a user with the following details:")
    public void iCreateAUser(Map<String, String> details) {
        CreateUserRequest request = new CreateUserRequest();
        request.setName(details.get("name"));
        request.setEmail(details.get("email"));
        request.setAge(Integer.parseInt(details.get("age")));
        request.setActive(true);

        context.setResponse(given().contentType(ContentType.JSON)
                .body(request).when().post("/users"));
    }

    @When(("I replace user {int} with the following details:"))
    public void iReplaceuser(int userId, Map<String, String> details) {
        CreateUserRequest request = new CreateUserRequest();
        request.setName(details.get("name"));
        request.setEmail(details.get("email"));
        request.setAge(Integer.parseInt(details.get("age")));

        context.setResponse(given().contentType(ContentType.JSON)
                .body(request).when().put("/users/" + userId));
    }

    @When("I partially update user {int} with body {string}")
    public void iPartiallyUpdateUser(int userId, String body) {
        context.setResponse(given().contentType(ContentType.JSON)
                .body(body).when().patch("/users/" + userId));
    }
}

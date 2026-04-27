Feature: Authentication API
  Token-based auth — tokens are valid for 30 minutes.

  Scenario: Get a token returns token and expiry
    When I request a new token
    Then the status code should be 201
    And the response should contain a token
    And the token expires_in should be 1800

  Scenario: Validate a valid token
    Given I have obtained a valid token
    When I validate the token
    Then the status code should be 200
    And the token should be valid

  Scenario: Validate without auth header returns 401
    When I validate the token without an auth header
    Then the status code should be 401
    And the token should not be valid

  Scenario: Validate with an invalid token returns 401
    When I validate the token with an invalid bearer
    Then the status code should be 401
    And the token should not be valid
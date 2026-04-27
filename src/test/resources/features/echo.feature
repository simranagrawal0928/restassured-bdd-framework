Feature: Echo API
  /echo returns the request body with a timestamp added.
  /echo/secure requires a valid Bearer token.

  Scenario: Echo returns body with timestamp
    When I send POST "/echo" with body:
        """
        { "name": "Alice", "role": "admin" }
        """
    Then the status code should be 200
    And the response field "name" should be "Alice"
    And the response field "role" should be "admin"
    And the response should contain a timestamp

  Scenario: Authenticated echo with valid token
    Given I have obtained a valid token
    When I send an authenticated POST to "/echo/secure" with body:
        """
        { "name": "Alice" }
        """
    Then the status code should be 200
    And the response field "name" should be "Alice"
    And the response should contain a timestamp

  Scenario: Authenticated echo without token returns 401
    When I send POST "/echo/secure" without auth with body:
        """
        { "name": "Alice" }
        """
    Then the status code should be 401

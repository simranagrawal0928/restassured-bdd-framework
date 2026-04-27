  Feature: User CRUD API
    Stateful in-memory store pre-seeded with 3 users on startup.
    Run scenarios in order on a fresh server.

    Scenario: Get all users return 3 seed users
        When I send GET "/users"
        Then the status code should be 200
        And the response should contain 3 users

    Scenario: Get user by ID returns correct details
        When I send GET "/users/1"
        Then the status code should be 200
        And the user name should be "Alice Nguyen"
        And the user email should be "alice@example.com"

      Scenario: User 2 has a null phone number
          When I send GET "/users/2"
          Then the status code should be 200
          And the user phone should be null

      Scenario: User 3 is inactive
          When I send GET "/users/3"
          Then the status code should be 200
          And the user active status should be "false"

      Scenario: Get non-existent user returns 404
          When I send GET "/users/999"
          Then the status code should be 404
          And the error should be "User 999 not found"

      Scenario: Create a new user
          When I create a user with the following details:
              | name   | Dave Lee         |
              | email  | dave@example.com |
              | age    | 25               |
          Then the status code should be 201
          And the user name should be "Dave Lee"
          And the user email should be "dave@example.com"

      Scenario: Full replace a user with PUT
          When I replace user 1 with the following details:
              | name   | Alice Updated         |
              | email  | alice-new@example.com |
              | age    | 35                    |
          Then the status code should be 200
          And the user name should be "Alice Updated"
          And the user age should be 35

      Scenario: Partial update a user with PATCH
          When I partially update user 2 with body '{"active": false}'
          Then the status code should be 200
          And the user active status should be "false"
          And the user name should be "Bob Martinez"

      Scenario: Delete a user
          When I send DELETE "/users/3"
          Then the status code should be 204

      Scenario: Delete non-existent user returns 404
          When I send DELETE "/users/999"
          Then the status code should be 404
          And the error should be "User 999 not found"
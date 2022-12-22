Feature: Get Post
  Verify different GET operations using REST-assured

  Scenario: Verify one author of the post 1
    Given I perform GET operation for "/posts/1"
    Then I should see the author name as "Karthik KK111"

  Scenario: Verify one author of the post 2
    Given I perform GET operation for "/posts/1"
    Then I should see the author name as "Karthik KK" with json validation

  Scenario: Verify one author of the post 3
    Given I perform GET operation for "/posts"
    Then I should see the key "author" name as "Karthik KK"

  Scenario: Verify one author of the post 4
    Given I perform GET operation for "/posts"
    Then I should see the key "title" name as "Appium"

  Scenario: Verify names
    Given I perform GET operation for "/post"
    Then I should see the author names

  Scenario: Verify pathParams of Get
    Given I perform GET operation for "/post"
    Then I should see verify GET Parameter

  Scenario: Verify queryParam  of Get
    Given I perform GET operation for "/post"
    Then I should see verify queryParam GET Parameter

  Scenario: Verify queryParam  of Get With RAE
    Given I perform GET operation for "/post"
    Then I should see verify queryParam GET Parameter

  Scenario: Verify Post operation 1
    Given I perform POST operation for "/posts"

  Scenario: Verify POST operation for profile 1
    Given I perform POST operation for "/posts/{profileNo}/profile" with body "name" as "Sam" and "profileNo" as "3"
    Then I should see the body has name as "Sam"

  @smoke
  Scenario: Verify GET operation with json validation
    Given I perform authentication operation for "/auth/login" with body
      | email             | password |
      | karthik@email.com | haha123  |
    Given I perform GET operation for "/posts/1" with token
    Then I should see the author name as "Karthik KK"



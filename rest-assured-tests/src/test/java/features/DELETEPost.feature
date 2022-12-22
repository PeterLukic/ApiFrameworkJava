Feature: Delete Post
  Test the delete operation

  Scenario: Verify DELETE operation after POST
    Given I ensure to Perform POST operation for "/posts" with body as
      | id | title              | author            |
      | 6  | API Testing course | ExecuteAutomation |
    And  I Perform DELETE operation for "/posts/{postid}/"
      | postid |
      | 6      |
    And I perform GET operation with path parameter for "/posts/{postid}"
      | postid |
      | 6      |
    Then I "should not" see the body with title as "API Testing course"



  Scenario: Verify DELETE operation after POST
    Given I ensure to Perform POST for "/posts" with body as
      | id | title              | author            |
      | 6  | API Testing course | ExecuteAutomation |

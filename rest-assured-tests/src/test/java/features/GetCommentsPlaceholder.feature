Feature: Get Comments Placeholder
  Verify different GET operations using REST-assured
  #url: https://jsonplaceholder.typicode.com/comments


 Scenario: Verify comments placeholder title of the post 1
   Given I perform GET operation comments placeholder for "/comments/1"
   Then I should see the placeholder comments email as "Eliseo@gardner.biz"

  #Failed test
  @OneTest
  Scenario: Verify comments placeholder title of the post 2
    Given I perform GET operation comments placeholder for "/comments/1"
    Then I should see the placeholder comments email as "wrongemail@test.com"
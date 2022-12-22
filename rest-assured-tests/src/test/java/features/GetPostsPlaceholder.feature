Feature: Get Post Placeholder
  Verify different GET operations using REST-assured
  #url: https://jsonplaceholder.typicode.com/posts

  Scenario: Verify post placeholder title of the post 1
    Given I perform GET operation posts placeholder for "/posts/1"
    Then I should see the placeholder posts title as "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
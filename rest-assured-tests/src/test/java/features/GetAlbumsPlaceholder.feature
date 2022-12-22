Feature: Get Albums Placeholder
  Verify different GET operations using REST-assured
  #url: https://jsonplaceholder.typicode.com/albums

  Scenario: Verify albums placeholder title of the post 1
    Given I perform GET operation albums placeholder for "/albums/1"
    Then I should see the placeholder albums title as "quidem molestiae enim"
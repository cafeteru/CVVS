Feature: Creation post

 Scenario: Post creation only title
    Given User is identified
    When tries to access the post creation menu
    And just enter the title
    Then the application does not create the post

  Scenario: Post creation only description
    Given User is correctly identified
    When access the post creation menu
    And just enter the description
    Then the application doesnt create the post

  Scenario: Post creation with title and description
    Given User can identified
    When him access the post creation menu
    And enter the title
    And enter the description
    Then the application create the post

  Scenario: Post creation with title too big and description
    Given User login
    When he goes to the post creation menu
    And enter a title too big
    And enter a description
    Then the application can create the post

  Scenario: Post creation with title and description too big
    Given User login correctly
    When he goes to the post creation menu again
    And enter a title
    And enter a description correctly
    Then the application can create the post correctly
    
  Scenario: Unidentified post creation
    Given User is not identified
    When tries to access the post creation menu directly
    Then the application will not let him in
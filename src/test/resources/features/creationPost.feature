Feature: Creation post

  Scenario: Unidentified post creation
    Given The user is not identified
    When tries to access the post creation menu directly
    Then the application will not let you in

  Scenario: Post creation only title
    Given The user is identified
    When tries to access the post creation menu
    And just enter the title
    Then the application does not create the post
    
   Scenario: Post creation only description
    Given The user is identified correctily
    When access the post creation menu
    And just enter the description
    Then the application doesnt create the post
Feature: View post

  Scenario: Admin post view
    Given Admin is identified
    When tries to access a users posts
    Then he can view the posts without problems
    
  Scenario: User sees his friends posts
    Given User is identified within the application
    When goes to his friends list
    And select one of them
    Then he can view his posts
    
  Scenario: User looks at the posts of another who is not a friend
    Given User is logged
    When goes directly to the list of a non-friend user
    Then he cant view his posts
    
  Scenario: Unidentified post view
    Given User isnt identified
    When tries to access the post view menu directly
    Then the application wont let him in
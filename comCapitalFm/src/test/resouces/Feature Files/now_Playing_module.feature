Feature: Check if Justin Bieber is playing or has recently played on Capital FM London

  As a user
  I want to check if current playing and recently played list can be seen
  So that I verify if Justin Bieber is playing or has recently played

  @test
  Scenario: verify if now playing list is seen or not
    Given I am on "Home" page
    And I a find "NOW PLAYING" or "RECENTLY PLAYED" on the page
    Then I check if "Justin Bieber" is now playing


  @test
  Scenario: verify if recently played list is seen with Justin Bieber on it
    Given I am on "Home" page
    And I a find "NOW PLAYING" or "RECENTLY PLAYED" on the page
    When I click "Recently played" on the page
    Then I should be on sub page "Last Played Songs" of "RADIO" page"
    Then I should see all the music tracks on the page played on that day
    And I should see tracks of "Justin B" played






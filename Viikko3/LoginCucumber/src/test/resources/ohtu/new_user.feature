Feature: A new user account can be created if a proper unused username and password are given

  Scenario: creation succesful with correct username and password
    Given command new user is selected
    When username "kukka" and password "heppa" are entered
    Then system will respond with "new user registered"

  Scenario: creation fails with correct username and too short password
    Given command new user is selected
    When username "poop" and password "poop" are entered
    Then system will respond with "new user not registered"

  Scenario: creation fails with correct username and password consisting of letters
    Given command new user is selected
    When username "lattia" and password "pipari" are entered
    Then system will respond with "new user not registered"

  Scenario: creation fails with too short username and valid passord
    Given command new user is selected
    When username "lattia" and password "pipari" are entered
    Then system will respond with "new user not registered"

  Scenario: creation fails with already taken username and valid pasword
    Given command new user is selected
    When user "user" with password "user" is created
    And command new user is selected
    And username "user" and password "user" are entered
    Then system will respond with "new user not registered"

  Scenario: can login with succesfully generated account
    Given user "kukkanen" with password "abc" is created
    And command login is selected
    When username "kukkanen" and password "abc" are entered
    Then system will respond with "logged in"

  Scenario: can not login with account that is not succesfully created
    Given user "piipaa" with password "poop" is created
    And command login is selected
    When username "pfhff" and password "fdfgdg" are entered
    Then system will respond with "wrong username or password"


Feature: Error validation
Background:
Given I landed on Ecommerce page  

@Errorvalidation
  Scenario Outline: Title of your scenario outline
    
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

     Examples: 
      | name  								|  password		    |
      | aakashsinha@gmail.com |  Kohli*9079     |

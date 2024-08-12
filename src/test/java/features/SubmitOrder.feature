Feature:Purchase the order from Ecommerce site

Background:
Given I landed on Ecommerce page
@Regression
  Scenario Outline: Positive Test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    And Select <countryName> and place the order
  	Then "THANKYOU FOR THE ORDER." is displayed on the screen

		 Examples: 
      |       name  					|  password		    |	productName | countryName |
      | aakashsinha@gmail.com |  Kohli*9079     | ZARA COAT 3 |    india    |
      


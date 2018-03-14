
Feature: Order T-shirt and verify in order history


  Scenario: User able to order a Tshirt
  Given user login to the application 
  When user selects a product and add it to cart
  And user orders a Tshirt
  Then order is reflecting in order history
 
  
  Scenario: User updates the personal information
  Given user login to the application  
  When user updates personal information
  Then updates are saved in user info
 

  
  
  
  
  
  


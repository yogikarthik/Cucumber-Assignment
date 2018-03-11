
Feature: Order T-shirt and verify in order history


  Scenario: User able to login to the application
  Given Open application and click signIn link 
  When User signIn with valid credentials and the homepage displayed
  When User selects a product and add the desired product to cart
  When Cart summary page is displayed and user clicks on Checkout button
  Then Content of address tab displayed
  When User agrees terms & conditions and clicks on Proceed to checkout button
  When User clicks Pay by bank wire link
 	Then Order summary page displayed and user clicks I confirm Order button
  When User navigates to order history
  Then Order history and Details menu Displayed
  
  Scenario: User updates the personal information
  Given Open application and click signIn link 
  When User signIn with valid credentials and the homepage displayed
  Then User clicks the Username and MyAccount page gets displayed
  When User updates the personal information and clicks Save button
  Then User gets a success message for the information update

  
  
  
  
  
  


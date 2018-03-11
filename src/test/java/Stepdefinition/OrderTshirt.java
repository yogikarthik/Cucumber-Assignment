package Stepdefinition;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.OrderHistoryPage;
import pageObjects.PaymentPage;
import pageObjects.ProductSelectionPage;
import pageObjects.UserInformationPage;

public class OrderTshirt {

	WebDriver driver;
	CheckoutPage checkoutpage;
	LoginPage loginpage;
	OrderHistoryPage orderhistorypage;
	PaymentPage paymentpage;
	ProductSelectionPage productselectionpage;
	UserInformationPage userinformationpage;
	PageObjectManager pageObjectManager;
	
	@Given("^Open application and click signIn link$")
	public void open_application_and_click_signIn_link() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:/TestLeaf/drivers/chromedriver.exe");
		driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    pageObjectManager = new PageObjectManager(driver);
	    loginpage = pageObjectManager.getLoginPage();
	    loginpage.openApplication();
	    loginpage.clickSignIn(); 		
	  	}
	
	@When("^User signIn with valid credentials and the homepage displayed$")
	public void user_signIn_with_valid_credentials_and_the_homepage_displayed() throws Throwable {
		
		//pageObjectManager = new PageObjectManager(driver);
		loginpage = pageObjectManager.getLoginPage();
		loginpage.userLogin();
		loginpage.verifyUserName();
		loginpage.clickTshirt();
		}
	
	@When("^User selects a product and add the desired product to cart$")
	public void user_selects_a_product_and_add_the_desired_product_to_cart() throws Throwable {	
		productselectionpage = pageObjectManager.getProductSelectionPage();
		productselectionpage.chkSelectionPage();			
		productselectionpage.isProductDisplayed();			
		}	
		
	@When("^Cart summary page is displayed and user clicks on Checkout button$")
	public void cart_summary_page_is_displayed_and_user_clicks_on_checkout_button() throws Throwable {
		checkoutpage = pageObjectManager.getCheckoutPage();
	    checkoutpage.clickProceedToChkoutBtn2();
	    }

	@Then("^Content of address tab displayed$")
	public void content_of_address_tab_displayed() throws Throwable {
		checkoutpage.clickProceedToChkoutBtn3();
		
	}

	@When("^User agrees terms & conditions and clicks on Proceed to checkout button$")
	public void user_agrees_terms_conditions_and_clicks_on_Proceed_to_checkout_button() throws Throwable {
		checkoutpage.clickTermsChkboxandchkoutBtn4();
	}

	
	@When("^User clicks Pay by bank wire link$")
	public void user_clicks_Pay_by_bank_wire_link() throws Throwable {
		checkoutpage.selectPaymentOption();
	}

	@Then("^Order summary page displayed and user clicks I confirm Order button$")
	public void order_summary_page_displayed_and_user_clicks_I_confirm_Order_button() throws Throwable {
		paymentpage = pageObjectManager.getPaymentPage();
		paymentpage.clickConfirmBtn();
		paymentpage.orderConfirmationPageDisplayed();
	}

	@When("^User navigates to order history$")
	public void user_navigates_to_order_history() throws Throwable {		
		paymentpage.navigateToOrders();
	    
	   }
	@Then("^Order history and Details menu Displayed$")
	public void order_history_and_Details_menu_Displayed(){
		orderhistorypage = pageObjectManager.getOrderHistoryPage();
		orderhistorypage.orderHistoryPageDisplayed();
		orderhistorypage.clickOrderReferenceLink();
		orderhistorypage.verifyOrderedItemName();
	}
	
	@Then("^User clicks the Username and MyAccount page gets displayed$")
	public void user_clicks_the_Username_and_MyAccount_page_gets_displayed(){
		userinformationpage = pageObjectManager.getUserInformationPage();
		userinformationpage.clickUsername();
		userinformationpage.clickUserInformationtab();
	}
	
	@When("^User updates the personal information and clicks Save button$")
	public void user_updates_the_personal_information_and_clicks_Save_button(){
		userinformationpage.updateUserInformation();
	}
	
	 @Then("^User gets a success message for the information update$")
	 public void user_gets_a_success_message_for_the_information_update(){
		 userinformationpage.validateUserInfoUpdated();
	 }
	
}

	
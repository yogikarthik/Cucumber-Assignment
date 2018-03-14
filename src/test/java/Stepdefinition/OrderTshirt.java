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

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataproviders.ConfigFileReader;
import managers.PageObjectManager;
import managers.WebDriverManager;
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
	ConfigFileReader configFileReader;
	WebDriverManager webDriverManager;
	
	
	
	@Given("^user login to the application$")
	public void user_login_to_the_application() throws Throwable {
	webDriverManager = new WebDriverManager();
	driver = webDriverManager.getDriver();
	pageObjectManager = new PageObjectManager(driver);
	loginpage = pageObjectManager.getLoginPage();
	loginpage.openApplication();
	loginpage.clickSignIn();
	loginpage.userLogin();
	loginpage.verifyUserName();
	loginpage.clickTshirt();
	  	}
	
	
	
	@When("^user selects a product and add it to cart$")
	public void user_selects_a_product_and_add_it_to_cart() throws Throwable {	
		
		productselectionpage = pageObjectManager.getProductSelectionPage();
		productselectionpage.chkSelectionPage();			
		productselectionpage.isProductDisplayed();
		checkoutpage = pageObjectManager.getCheckoutPage();
	    checkoutpage.clickProceedToChkoutBtn2();
	    checkoutpage.clickProceedToChkoutBtn3();
	    checkoutpage.clickTermsChkboxandchkoutBtn4();
	    checkoutpage.selectPaymentOption();
		}	
	@And("^user orders a Tshirt$")
	public void order_summary_page_displayed_and_user_clicks_I_confirm_Order_button() throws Throwable {
		paymentpage = pageObjectManager.getPaymentPage();
		paymentpage.clickConfirmBtn();
		paymentpage.orderConfirmationPageDisplayed();
		paymentpage.navigateToOrders();
	}

	@Then("^order is reflecting in order history$")
	public void order_is_reflecting_in_order_history() throws Throwable {		
		orderhistorypage = pageObjectManager.getOrderHistoryPage();
		orderhistorypage.orderHistoryPageDisplayed();
		orderhistorypage.clickOrderReferenceLink();
		orderhistorypage.verifyOrderedItemName();
	    
	   }
	
	
	@When("^user updates personal information$")
	public void user_updates_personal_information(){
		userinformationpage = pageObjectManager.getUserInformationPage();
		userinformationpage.clickUsername();
		userinformationpage.clickUserInformationtab();
		userinformationpage.updateUserInformation();
	}
	
	
	
	@Then("^updates are saved in user info$")
	public void updates_are_saved_in_user_info(){
		 userinformationpage.validateUserInfoUpdated();
	 }
	
}

	
package managers;

import org.openqa.selenium.WebDriver;

import dataproviders.ConfigFileReader;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.OrderHistoryPage;
import pageObjects.PaymentPage;
import pageObjects.ProductSelectionPage;
import pageObjects.UserInformationPage;

public class PageObjectManager {

	public WebDriver driver;
	private CheckoutPage checkoutpage;
	public LoginPage loginpage;
	private OrderHistoryPage orderhistorypage;
	private PaymentPage paymentpage;
	private ProductSelectionPage productselectionpage;
	private UserInformationPage userinformationpage;
	
	
	
	public PageObjectManager(WebDriver driver) {
		
		 
		this.driver = driver;
 
	}
	
	
	public LoginPage getLoginPage(){
		 
		return (loginpage == null) ? loginpage = new LoginPage(driver) : loginpage;
 
	}
	
	public ProductSelectionPage getProductSelectionPage(){
		 
		return (productselectionpage == null) ? productselectionpage = new ProductSelectionPage(driver) : productselectionpage;
 
	}
	public CheckoutPage getCheckoutPage(){
		 
	return (checkoutpage == null) ? checkoutpage = new CheckoutPage(driver) : checkoutpage;
 
	}
	public PaymentPage getPaymentPage(){
		 
		return (paymentpage == null) ? paymentpage = new PaymentPage(driver) : paymentpage;
 
	}
	public OrderHistoryPage getOrderHistoryPage(){
		 
		return (orderhistorypage == null) ? orderhistorypage = new OrderHistoryPage(driver) : orderhistorypage;
 
	}
	public UserInformationPage getUserInformationPage() {
		return (paymentpage == null) ? userinformationpage = new UserInformationPage(driver) : userinformationpage;
	}
	}

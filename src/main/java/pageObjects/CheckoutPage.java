package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using= "//h1[contains(text(),'Shopping-cart summary')]")
	private WebElement Title_Cartsummary;
	@FindBy(how=How.XPATH, using= "//p[@class='product-name']/following::*[@class='product-name']")
	private WebElement Validate_Name;
    @FindBy(how=How.XPATH, using= "//span[contains(text(),'Proceed to checkout')]/following::span[contains(text(),'Proceed to checkout')]")
	private WebElement Button2_Checkout;
	@FindBy(how=How.XPATH, using= "//h1[contains(text(),'Addresses')]")
	private WebElement Title_Address;
	@FindBy(how=How.XPATH, using= "//span[contains(text(),'Proceed to checkout')]/following::span[contains(text(),'Proceed to checkout')]")
	private WebElement Button3_Checkout;
	@FindBy(how=How.XPATH, using= "//h1[contains(text(),'Shipping')]")
	private WebElement Title_Shipping;
	@FindBy(how=How.XPATH, using= "//*[@id='cgv']")
	private WebElement CheckBox_Terms;
	@FindBy(how=How.XPATH, using= "//button/following::span[contains(text(),'Proceed to checkout')][2]")
	private WebElement Button4_checkout;
	@FindBy(how=How.XPATH, using= "//span[contains(text(),'Your payment method')]")
	private WebElement Title_Payment;
	@FindBy(how=How.XPATH, using= "//a[@class='bankwire']")
	private WebElement Option_Bankwire;
	
	
	public void clickProceedToChkoutBtn2(){	
		//String winhandle=driver.getWindowHandle();
		
		if(Title_Cartsummary.isDisplayed()){
			//String PageTitle=Title_Cartsummary.getText();
			String ProdName=Validate_Name.getText();
			String SelectedProduct="Faded Short Sleeve T-shirts";
			if(ProdName.equalsIgnoreCase(SelectedProduct)){
			   Button2_Checkout.click();
		}
		}
	}
		
	
	public void clickProceedToChkoutBtn3(){
		if(Title_Address.isDisplayed()){
			Button3_Checkout.click();
		}
	}
	
	public void clickTermsChkboxandchkoutBtn4(){
		if(Title_Shipping.isDisplayed()){
		CheckBox_Terms.click();
		Button4_checkout.click();
		}
	}
	
	public void selectPaymentOption(){
		Title_Payment.isDisplayed();
		Option_Bankwire.click();
	}
	public void selectPaymentMode(){
		clickProceedToChkoutBtn2();
		clickProceedToChkoutBtn3();
		clickTermsChkboxandchkoutBtn4();
		selectPaymentOption();
		
	}
	


	
	
}

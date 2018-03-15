package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
WebDriver driver;
	
	public PaymentPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH, using= "//h1[contains(text(),'    Order summary')]")
	private WebElement Title_OrderSummary;
	@FindBy(how=How.XPATH, using= "//h3[@class='page-subheading']")
	private WebElement Title_Paymenttype;
	@FindBy(how=How.XPATH, using= "//span[contains(text(),'I confirm my order')]")
	private WebElement Button_ConfirmOrder;
	@FindBy(how=How.XPATH, using= "//h1[contains(text(),'Order confirmation')]")
	private WebElement Title_OrderComplete;
	@FindBy(how=How.XPATH, using= "//strong[contains(text(),'My Store is complete.')]")
	private WebElement Message_orderCOnfirm;
	@FindBy(how=How.XPATH, using= "//a[@title='Back to orders']")
	private WebElement Navigate_Backtoorders;
	
	public void clickConfirmBtn(){
		String selectedpaymenttype="BANK-WIRE PAYMENT";
		if(Title_OrderSummary.isDisplayed()){
			String paymentOption=Title_Paymenttype.getText();			
			//if(paymentOption.equalsIgnoreCase(selectedpaymenttype)){
				//JavascriptExecutor js=(JavascriptExecutor)driver;
				//js.executeScript("window.scrollBy(0,3000)");
				Button_ConfirmOrder.click();
				System.out.println("The user confirms the payment type");
			//}
		}
	}
	
	public void orderConfirmationPageDisplayed(){
		if(Title_OrderComplete.isDisplayed()){
			String Ordermessage="Your order on My Store is complete.";
			String ActualMessage=Message_orderCOnfirm.getText();
			if(ActualMessage.equalsIgnoreCase(Ordermessage)){
				System.out.println("The order has been placed successfully");
				
			}
		}
	}
	
	public void navigateToOrders(){
		Navigate_Backtoorders.click();
	}
	
	public void orderTshirt(){
		clickConfirmBtn();
		orderConfirmationPageDisplayed();
		navigateToOrders();
		
		
		
	}
	
	
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
	WebDriver driver;
	
	public OrderHistoryPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(how=How.XPATH, using= "//h1[contains(text(),'Order history')]")
	private WebElement Title_OrderHistory;
	@FindBy(how=How.XPATH, using= "//*[@id='order-list']/tbody/tr[1]/td[1]/a")
	private WebElement Link_OrderItem;
	@FindBy(how=How.XPATH, using= "//*[@id='order-detail-content']/table/tbody/tr/td[2]/label")
	private WebElement Verify_Order;
	
	public void orderHistoryPageDisplayed(){
		if(Title_OrderHistory.isDisplayed()){
		Link_OrderItem.click();
	}
	}
	public void clickOrderReferenceLink(){
		System.out.println("The Order reference link has been clicked");
	}
	public void verifyOrderedItemName(){
		String ActualOrderItem="Faded Short Sleeve T-shirts";
		String OrderedItemName=Verify_Order.getText();
		OrderedItemName.equals(ActualOrderItem);
	}
}

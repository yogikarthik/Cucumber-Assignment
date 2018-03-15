package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductSelectionPage {
	WebDriver driver;
	public ProductSelectionPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH, using= "//p[contains(text(),'Catalog')]")
	private WebElement Block_Catalog;
	@FindBy(how=How.XPATH, using= "//img[@title='Faded Short Sleeve T-shirts']")
	private WebElement Image_Tshirt;
	@FindBy(how=How.XPATH, using= "//*[@id='center_column']/div/div/div[3]/h1")
	private WebElement Text_ProductName; 
	@FindBy(how=How.XPATH, using= "//span[contains(text(),'Add to cart')]")
	private WebElement Button_addtocart; 
	@FindBy(how=How.XPATH, using= "//*[@id='layer_cart']/div[1]/div[1]/h2/i")
	private WebElement Icon_Tick;
	@FindBy(how=How.XPATH, using= "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	private WebElement Button_Checkout;
	
	public void chkSelectionPage(){
		if(Block_Catalog.isDisplayed()){
			System.out.println("The Product selection page is displayed");
		}
	}
	public void isProductDisplayed() throws InterruptedException{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		if(Image_Tshirt.isDisplayed()){
			String winhandle=driver.getWindowHandle();
			WebElement element=Image_Tshirt;
	    	Actions action=new Actions(driver);
	    	action.moveToElement(element).perform();
	    	WebElement subElement=Button_addtocart;
	    	action.moveToElement(subElement);
	    	action.click();
	    	action.perform();		
	    	Thread.sleep(2000);
		for(String OpenWindow:driver.getWindowHandles()){
	    	driver.switchTo().window(OpenWindow);
	    	if(Icon_Tick.isDisplayed()){
	    		Button_Checkout.click();
	    		break;
	    	}
	    	
		}driver.switchTo().window(winhandle);
		
	  }
					
		}
		
	public void selectProduct() throws Exception {
		chkSelectionPage();
		isProductDisplayed();
		
		
	}
	
	
	
}

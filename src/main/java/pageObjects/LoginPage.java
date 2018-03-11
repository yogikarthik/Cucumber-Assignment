package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(how=How.XPATH, using= "//a[@class='login']")
private WebElement Link_signIn;
@FindBy(how=How.XPATH, using= "//h1[contains(text(),'Authentication')]")
private WebElement Title_Authentication;
@FindBy(how=How.XPATH, using= "//input[@id='email']")
private WebElement Textbox_Email;
@FindBy(how=How.XPATH, using= "//input[@id='passwd']")
private WebElement Textbox_Pwd;
@FindBy(how=How.XPATH, using= "//*[@id='SubmitLogin']")
private WebElement button_Signin;
@FindBy(how=How.XPATH, using= "//span[contains(text(),'Test auto')]")
private WebElement Verify_Username;
@FindBy(how=How.XPATH, using= "//h1[contains(text(),'My account')]")
private WebElement Title_MyAccount;
@FindBy(how=How.XPATH, using= "//a[contains(text(),'T-shirts')]/following::*[contains(text(),'T-shirts')]")
private WebElement Option_Tshirts; 

    public void openApplication(){
	
    	driver.get("http://automationpractice.com");
    }
    public void clickSignIn(){
    	if(Link_signIn.isDisplayed()){
    	Link_signIn.click();
    	}
    }
	public void userLogin(){
		//String usrname="automation22@gmail.com";
		//String Pwd="12345";
		if(Title_Authentication.isDisplayed()){
		Textbox_Email.sendKeys("automation22@gmail.com");	
		Textbox_Pwd.sendKeys("12345");
		button_Signin.click();
	}
	}
	public void verifyUserName(){
		String ExpectedValue="Test auto";
		String ActualValue=Verify_Username.getText();
		if(ExpectedValue.equalsIgnoreCase(ActualValue)){
			System.out.println("The application opened for the registered user");
			String PageTitle=Title_MyAccount.getText();
		}
			}
	public void clickTshirt(){
		if(Title_MyAccount.isDisplayed()){
		Option_Tshirts.click();
	}
	}
	
}

package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dataproviders.ConfigFileReader;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;

public class LoginPage extends ConfigFileReader{
	WebDriver driver;
	ConfigFileReader configFileReader;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	LoginPage loginpage;
	
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
    	
    	driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    	
    }
    public void clickSignIn(){
    	if(Link_signIn.isDisplayed()){
    	Link_signIn.click();
    	}
    }
	public void userLogin(){		
		if(Title_Authentication.isDisplayed()){
		Textbox_Email.sendKeys(FileReaderManager.getInstance().getConfigReader().enterUserName());	
		Textbox_Pwd.sendKeys(FileReaderManager.getInstance().getConfigReader().enterpassword());
		button_Signin.click();
	}
	}
	public void verifyUserName(){
		String ActualValue=Verify_Username.getText();
		if(ActualValue.equalsIgnoreCase(FileReaderManager.getInstance().getConfigReader().getUserName())){
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

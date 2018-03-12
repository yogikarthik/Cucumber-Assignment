package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserInformationPage {
WebDriver driver;
	
	public UserInformationPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(how=How.XPATH, using= "//a[@class='account']")
	private WebElement Link_UserAccount;
	@FindBy(how=How.XPATH, using= "//h1[contains(text(),'My account')]")
	private WebElement Title_MyAccount;
	@FindBy(how=How.XPATH, using= "//span[contains(text(),'My personal information')]")
	private WebElement Tab_UserInformation;
	@FindBy(how=How.XPATH, using= "//h1[contains(text(),'Your personal information')]")
	private WebElement Title_PersonalInformation;
	@FindBy(how=How.XPATH, using= "//h1[contains(text(),'Your personal information')]")
	private WebElement Textbox_FirstName;
	@FindBy(how=How.XPATH, using= "//span[contains(text(),'Save')]")
	private WebElement Button_Save;
	@FindBy(how=How.XPATH, using= "//input[@id='old_passwd']")
	private WebElement Textbox_oldpwd;
	@FindBy(how=How.XPATH, using= "//p[@class='alert alert-success']")
	private WebElement Message_success;
	
	
	public void clickUsername(){
		Link_UserAccount.click();
				
		}
	public void clickUserInformationtab(){
		if(Title_MyAccount.isDisplayed()){
			Tab_UserInformation.click();
		}
		}
	
	public void updateUserInformation(){
		if(Title_PersonalInformation.isDisplayed()){
			//Textbox_FirstName.click();
			Textbox_FirstName.sendKeys(Keys.ENTER);;
			Textbox_FirstName.sendKeys("1");
			Textbox_oldpwd.sendKeys("12345");
			Button_Save.click();
		}
	}
	public void validateUserInfoUpdated(){
		if(Message_success.isDisplayed()){
			System.out.println("The user information has been updated successfully");
		}
	}
	

}

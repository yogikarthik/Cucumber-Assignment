package dataproviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.Before;
import enums.DriverType;
import enums.EnvironmentType;
import managers.PageObjectManager;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.OrderHistoryPage;
import pageObjects.PaymentPage;
import pageObjects.ProductSelectionPage;
import pageObjects.UserInformationPage;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilepath="Configs//configurations.properties";
	
	
	public ConfigFileReader(){
		BufferedReader reader;
		try{
			reader=new BufferedReader(new FileReader(propertyFilepath));
			properties=new Properties();
		try {
			properties.load(reader);
			reader.close();
		}
				catch (IOException e){
				e.printStackTrace();
				
				}
		}
					catch (FileNotFoundException e) {
					e.printStackTrace();
					throw new RuntimeException("Configuration.properties not found at " + propertyFilepath);
				}
			}
		
		public long getImplicitlyWait() {		
			String implicitlyWait = properties.getProperty("implicitlyWait");
			if(implicitlyWait != null) 
				{
				try{
					return Long.parseLong(implicitlyWait);
				}catch(NumberFormatException e) {
					throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
				}
			}
			return 30;
				}
			
		public String getDriverPath(){
			String driverPath=properties.getProperty("driverPath");
			if(driverPath!= null) return driverPath;
			else throw new RuntimeException("driverPath not specified in the configuration.properties file.");		
		}
		
		public String getApplicationUrl() {
			String url = properties.getProperty("url");
			if(url != null) return url;
			else throw new RuntimeException("url not specified in the Configuration.properties file.");
		}
		public String enterUserName(){
			String uname = properties.getProperty("uname");
			if(uname != null) return uname;
			else throw new RuntimeException("uname not specified in the Configuration.properties file.");
		}
		public String enterpassword(){
			String pwd = properties.getProperty("pwd");
			if(pwd != null) return pwd;
			else throw new RuntimeException("pwd not specified in the Configuration.properties file.");
		}
		public String getUserName(){
			String registeredUserName = properties.getProperty("registeredUserName");
			if(registeredUserName != null) return registeredUserName;
			else throw new RuntimeException("registeredUserName not specified in the Configuration.properties file.");
		}
		
		public DriverType getBrowser() {
			String browserName = properties.getProperty("browser");
			if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
			else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
			else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
			else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
		}
		public EnvironmentType getEnvironment() {
			String environmentName = properties.getProperty("environment");
			if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
			else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
			else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
		}
	 
		public Boolean getBrowserWindowSize() {
			String windowSize = properties.getProperty("windowMaximize");
			if(windowSize != null) return Boolean.valueOf(windowSize);
			return true;
		}
		
		
}

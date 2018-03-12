package dataproviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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
		
		public String getDriverPath(){
			String driverPath=properties.getProperty("driverPath");
			if(driverPath!= null) return driverPath;
			else throw new RuntimeException("driverPath not specified in the configuration.properties file.");		
		}
		
		public long getImplicitlyWait() {		
			String implicitlyWait = properties.getProperty("implicitlyWait");
			if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
			else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
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
}

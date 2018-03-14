package managers;

import dataproviders.ConfigFileReader;

public class FileReaderManager {
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
 
	public FileReaderManager() {
	}
 
	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }
 
	 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	 }


}

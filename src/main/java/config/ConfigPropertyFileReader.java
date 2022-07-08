package config;




import interfaces.IConfigReader;
import settings.ObjectRepo;
import utility.ResourceHelper;

import java.io.File;
import java.util.Properties;

public class ConfigPropertyFileReader implements IConfigReader {

	private static Properties prop = null;

	public ConfigPropertyFileReader() {
		prop = new Properties();
		try {
			prop.load(ResourceHelper.getResourcePathInputStream("configFile"+File.separator+"config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public String getWebsite() {
		System.out.println("Here");
		return prop.getProperty(ObjectRepo.Environment+"_Website");
	}

	public String getExecutionEnv() {
		System.out.println("Here");
		return prop.getProperty("ExecutionEnv");
	}


	public String getRemoteExecutionEnvURL() {
		return prop.getProperty("RemoteExecutionEnvURL");
	}

	@Override
	public String getImageDataFolderPath() {
		return null;
	}


	public int getPageLoadTimeOut() {
		System.out.println("Here");
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	public String getWaitTime() {
		System.out.println("Here");

		String time = prop.getProperty("wait.explicit.seconds");
		if (time != null)
			return time;
		else
			throw new RuntimeException("Time  is  not specified in the Configuration.properties file.");

	}

	public int getImplicitWait() {
		System.out.println("Here");

		return Integer.parseInt(prop.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		System.out.println("Here");
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}





}

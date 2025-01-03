package com.snd.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.snd.enums.DriverType;
import com.snd.enums.EnvironmentType;

public class ConfigReader {
	private Properties prop;
	private final String propertyFilePath = "Config//configuration.properties";

	public ConfigReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			prop = new Properties();
			try {
				prop.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties file not found at " + propertyFilePath);
		}
	}

	public String getEnvironment() {
		return prop.getProperty("Environment");
	}

	public String getAppName() {
		return prop.getProperty("App_Name");
	}

	public String getBuild() {
		return prop.getProperty("Build");
	}

	public String getTestAuthor() {
		return prop.getProperty("Test_Author");
	}

	public String getReportConfigPath() {
		String configPath = prop.getProperty("Report_Config_Path");
		if (configPath != null) {
			return configPath;
		} else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	public String getChromeDriverPath()
	{
		String chromeDriverPath = prop.getProperty("Chrome_Driver_Path");
		if(chromeDriverPath != null)
			return chromeDriverPath;
		else
			throw new RuntimeException("Chrome driver path not found in the configuration file");
	}
	public String getFirefoxDriverPath()
	{
		String firefoxDriverPath = prop.getProperty("Firefox_Driver_Path");
		if(firefoxDriverPath != null)
			return firefoxDriverPath;
		else
			throw new RuntimeException("Firefox driver path not found in the configuration file");
	}
	public String getIEDriverPath()
	{
		String iEDriverPath = prop.getProperty("Internet_Explorer_Driver_Path");
		if(iEDriverPath != null)
			return iEDriverPath;
		else
			throw new RuntimeException("IE driver path not found in the configuration file");
	}
	public int getWaitTime() {
		String waitTime = prop.getProperty("Implicit_Wait");
		if (waitTime != null) {
			try {
				return Integer.parseInt(waitTime);
			} catch (NumberFormatException e) {
				throw new RuntimeException("Time for implicit wait is not provided in configuration file");
			}
		}
		return 30;

	}

	public String getBaseUrl() {
//		String baseUrl = prop.getProperty("Base_Url");
		String environment = System.getProperty("env");
		if (environment != null) {
			if(environment.equalsIgnoreCase("qa"))
				return prop.getProperty("Base_Url_QA");
			else
				return prop.getProperty("Base_Url_UAT");
		} 
		else
		{
			return prop.getProperty("Base_Url_QA");
//			throw new RuntimeException("Base Url not found in the configuration file");
		}
		
	}

	public DriverType getBrowser() {
		String browserName = System.getProperty("browser");
		if (browserName == null || browserName.equalsIgnoreCase("chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equalsIgnoreCase("Edge"))
			return DriverType.EDGE;
		else
			throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched");

	}

	public EnvironmentType getEnvironmentForDriver() {
		String environmentName = prop.getProperty("EnvironmentDriver");
		if (environmentName == null || environmentName.equalsIgnoreCase("local"))
			return EnvironmentType.LOCAL;
		else if (environmentName.equalsIgnoreCase("remote"))
			return EnvironmentType.REMOTE;
		else
			throw new RuntimeException(
					"Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public boolean getBrowserWindowSize() {
		String windowSize = prop.getProperty("Window_Maximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		else
			return true;
	}
}

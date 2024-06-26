package com.snd.utilities;

import org.openqa.selenium.WebDriver;

import com.snd.managers.FileReaderManager;

public class BaseClass {

	private WebDriver driver;
	
	public BaseClass(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void enterBaseUrl() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getBaseUrl());
	}
}

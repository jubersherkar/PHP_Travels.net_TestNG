package com.snd.utilities;

import org.openqa.selenium.WebDriver;

import com.snd.managers.FileReaderManager;
import com.snd.pageObjects.HomePage;

public class BaseClass {

	private WebDriver driver;
//	private HomePage homePage;
	
	public BaseClass(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void enterBaseUrl() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getBaseUrl());

//		code for selecting English language
//		homePage = new HomePage(driver);
//		homePage.transaleToEnglish();
	}
}

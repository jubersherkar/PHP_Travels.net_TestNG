package com.snd.managers;

import org.openqa.selenium.WebDriver;

import com.snd.pageObjects.FlightSearchResultPage;
import com.snd.pageObjects.HomePage;
import com.snd.pageObjects.LoginPage;
import com.snd.utilities.BaseClass;

public class PageObjectManager 
{
	private WebDriver driver;
	private BaseClass baseClass;
	private LoginPage loginPage;
	private HomePage homePage;
	private FlightSearchResultPage flightSearchResultPage;

	public PageObjectManager(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public BaseClass getBaseClass()
	{
		return (baseClass == null) ? baseClass = new BaseClass(driver):baseClass;
	}
	public LoginPage getLoginPage()
	{
		if(loginPage == null)
		{
			loginPage = new LoginPage(driver);
			return loginPage;
		}
		else
		{
			return loginPage;
		}
	}
	public HomePage getHomePage()
	{
		return (homePage == null) ? homePage = new HomePage(driver):homePage;
	}
	public FlightSearchResultPage getFlightSearchResultPage()
	{
		return (flightSearchResultPage == null)?flightSearchResultPage = new FlightSearchResultPage(driver):flightSearchResultPage;
	}
}

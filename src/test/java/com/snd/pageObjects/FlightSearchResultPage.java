package com.snd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightSearchResultPage 
{
	private WebDriver driver;
//	private WebDriverWait wait;
//	private Actions action;
	
	public FlightSearchResultPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[1]//form[1]/div/div/div/div/img")
	private WebElement departureFlightAirlineLogo;
	
	@FindBy(xpath = "//li[1]//form[1]/div/div[2]//img")
	private WebElement arrivalFlightAirlineLogo;
	
	@FindBy(xpath = "//li[1]//form[1]/div/div/div[2]/p")
	private WebElement departureFlightNumber;
	
	@FindBy(xpath = "//li[1]//form[1]/div/div[2]/div/div[2]/p")
	private WebElement arrivalFlightNumber;
	
	@FindBy(xpath = "//li[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/p[2]")
	private WebElement departureFlightDuration;
	
	@FindBy(xpath = "//li[1]/form[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/p[1]")
	private WebElement arrivalFlightDuration;
	
	@FindBy(xpath = "//li[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/p[1]")
	private WebElement departureFlightStops;
	
	@FindBy(xpath = "//li[1]/form[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/h6[1]")
	private WebElement arrivalFlightStops;
	
	@FindBy(xpath = "//li[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/p[2]")
	private WebElement departureFlightConnections;
	
	@FindBy(xpath = "//li[1]/form[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/p[1]")
	private WebElement arrivalFlightConnections;
	
	@FindBy(xpath = "//li[1]/form[1]/div[1]/div[3]/h6[1]")
	private WebElement fareStartFrom;
	
	@FindBy(xpath = "//li[1]/form[1]/div[1]/div[3]/div[1]/button[1]")
	private WebElement moreDetailsButton;
	
	@FindBy(xpath = "//li[1]/form[1]/div[1]/div[3]/div[1]/button[2]")
	private WebElement SelectFlightButton;
	
	public WebElement getDepartureFlightAirlineLogo()
	{
		return departureFlightAirlineLogo;
	}
	public WebElement getArrivalFlightAirlineLogo()
	{
		return arrivalFlightAirlineLogo;
	}
	public WebElement getDepartureFlightNumber()
	{
		return departureFlightNumber;
	}
	public WebElement getArrivalFlightNumber()
	{
		return arrivalFlightNumber;
	}
	public WebElement getDepartureFlightDuration()
	{
		return departureFlightDuration;
	}
	public WebElement getArrivalFlightDuration()
	{
		return arrivalFlightDuration;
	}
	public WebElement getDepartureFlightStops()
	{
		return departureFlightStops;
	}
	public WebElement getArrivalFlightStops()
	{
		return arrivalFlightStops;
	}
	public WebElement getDepartureFlightConnections()
	{
		return departureFlightConnections;
	}
	public WebElement getArrivalFlightConnections()
	{
		return arrivalFlightConnections;
	}
	public WebElement getfareStartFrom()
	{
		return fareStartFrom;
	}
	public WebElement getMoreDetailsButton()
	{
		return moreDetailsButton;
	}
	public WebElement getSelectFlightButton()
	{
		return SelectFlightButton;
	}
}

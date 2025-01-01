package com.snd.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage
{
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//header/div[1]/div[1]/a[1]/img[1]")
	private WebElement phpLogo;

	@FindBy(xpath = "//header/div[1]/div[2]/div[2]/ul[1]/li[1]/a[1]/*[1]")
	private WebElement languageDropDown;

	@FindBy(xpath = "//header/div[1]/div[2]/div[2]/ul[1]/li[2]/a[1]/*[1]")
	private WebElement currencyDropDown;

	@FindBy(xpath = "//strong[normalize-space()='Account']")
	private WebElement accountDropDown;

	@FindBy(xpath = "//a[normalize-space()='Flights']")
	private WebElement flightsTab;

	@FindBy(xpath = "//button[@data-bs-target='#tab-hotels']")
	private WebElement hotelTab;

	@FindBy(xpath = "//button[@data-bs-target='#tab-tours']")
	private WebElement toursTab;

	@FindBy(xpath = "//button[@data-bs-target='#tab-cars']")
	private WebElement carsTab;

	@FindBy(xpath = ".//div[contains(@class,'one-way')]")
	private WebElement oneWay;

	@FindBy(xpath = ".//div[contains(@class,'round-trip form')]")
	private WebElement roundTrip;

	@FindBy(xpath = "//select[@id='flight_type']")
	private WebElement cabinClass;

	@FindBy(xpath = "//input[@name='from']")
	private WebElement originField;

	@FindBy(xpath = "//input[@name='to']")
	private WebElement destinationField;

	@FindBy(xpath = "//input[@id='departure']")
	private WebElement departureDate;
	
	@FindBy(xpath = "//input[@id='return_date']")
	private WebElement returnDate;

	@FindBy(xpath = "//a[@class='dropdown-toggle dropdown-btn travellers waves-effect']")
	private WebElement travellersDropDown;

	@FindBy(xpath = "//button[@id='flights-search']")
	private WebElement searchButton;

	@FindBy(xpath = "//body/section[@data-aos='fade-up']/div/div/div/div/div/div[1]")
	private WebElement contactInfo;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement name;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;

	@FindBy(xpath = "//button[normalize-space()='Signup Newsletter']")
	private WebElement signUpNewsLetter;

	@FindBy(xpath = "//ul[@class='list-items list--items align-items-center text-start text-lg-start text-md-center text-center text-dark']")
	private WebElement disclaimer;

	@FindBy(xpath = "//a[@href='http://www.phptravels.com']")
	private WebElement bottomLogo;

	@FindBy(xpath = "//div[@class='footer-social-box float-center float-lg-end']")
	private WebElement mediaIcons;

	@FindBy(xpath = "//input[@id='fadults']")
	private WebElement adults;

	@FindBy(xpath = "//input[@id='fchilds']")
	private WebElement child;

	@FindBy(xpath = "//input[@id='finfant']")
	private WebElement infant;



	public boolean verifyPresenceOfLogo()
	{
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(phpLogo));
		return phpLogo.isDisplayed();
	}
	public boolean verifyPresenceOfLanguageDropDown()
	{
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ShowSearchBox']")));
		languageDropDown.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@data-bs-popper='static']//li[1]")));
		return driver.findElement(By.xpath("//ul[@data-bs-popper='static']//li[1]")).isDisplayed();
	}
	public boolean verifyPresenceOfCurrencyDropDown()
	{
		currencyDropDown.click();
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://phptravels.net/currency/EUR']")));
		return driver.findElement(By.xpath("//a[@href='https://phptravels.net/currency/EUR']")).isDisplayed();
	}
	public boolean verifyPresenceOfAccountDropDown()
	{
		accountDropDown.click(); 
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://phptravels.net/login']")));
		return driver.findElement(By.xpath("//a[@href='https://phptravels.net/login']")).isDisplayed();
	}
	public boolean verifyPresenceOfProducts()
	{
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElements(flightsTab,hotelTab,toursTab,carsTab));

		return flightsTab.isDisplayed() && hotelTab.isDisplayed() 
				&& toursTab.isDisplayed() && carsTab.isDisplayed();
	}
	public boolean verifyPresenceOfTripOptions()
	{
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElements(oneWay,roundTrip));
		return oneWay.isDisplayed() && roundTrip.isDisplayed();
	}
	public WebElement verifyCabinClass(int i)
	{
		Select select = new Select(cabinClass);
		List<WebElement> optionsList = select.getOptions();
		return optionsList.get(i);
	}
	public boolean verifyPresenceOfOriginDestinationDateTravellerSearch()
	{
		return originField.isDisplayed() && destinationField.isDisplayed() && departureDate.isDisplayed()
				&& travellersDropDown.isDisplayed() && searchButton.isDisplayed();
	}
	public boolean verifyContactDetailsInFooter()
	{
		wait = new WebDriverWait(driver, 5);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");
		wait.until(ExpectedConditions.visibilityOf(contactInfo));
		return contactInfo.isDisplayed();
	}
	public boolean verifyPresenceOfNameEmailSignUpNewsletter()
	{
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElements(name,email,signUpNewsLetter));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");
		return name.isDisplayed() && email.isDisplayed() && signUpNewsLetter.isDisplayed();
	}
	public boolean verifyPresenceOfFooters()
	{
		//		Clicked on hide button
		driver.findElement(By.xpath("//button[@id='cookie_stop']")).click();
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElements(disclaimer,bottomLogo,mediaIcons));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,60000)");

		if(disclaimer.getText().trim().equals("All Rights Reserved by PHPTARVELS")
				&& bottomLogo.isDisplayed() && mediaIcons.isDisplayed())
			return true;
		else 
			return false; 
	}
	public void clickOnOneWay()
	{
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(oneWay)).click();
	}
	public void clickOnRoundTrip()
	{
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(roundTrip)).click();
	}
	public void selectCabin(String cab)
	{	
		Select cabin = new Select(cabinClass);
		if(cab.contains("Economy"))
		{
			action.sendKeys(Keys.TAB);
		} 
		else if(cab.contains("Premium"))
			cabin.selectByIndex(1);
		else if(cab.contains("Business"))
			cabin.selectByIndex(2);
		else if(cab.contains("First"))
			cabin.selectByIndex(3);
	}
	public void enterOrigin(String org)
	{
		wait = new WebDriverWait(driver, 5);
		action.sendKeys(Keys.TAB,Keys.ENTER).perform();
		wait.until(ExpectedConditions.visibilityOf(originField)).sendKeys(org + " ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='"+org.toUpperCase()+"']")));
		action.sendKeys(Keys.ENTER).perform();
	}
	public void enterDestination(String dest)
	{
		wait = new WebDriverWait(driver, 5);
		action.sendKeys(Keys.TAB,Keys.ENTER).perform();
		wait.until(ExpectedConditions.visibilityOf(destinationField)).sendKeys(dest + " ");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[normalize-space()='"+dest.toUpperCase()+"']")));
		action.sendKeys(Keys.ENTER).perform();
	}
	public void enterDepartDate(String dt)
	{
		departureDate.clear();
		departureDate.sendKeys(dt);
	}
	public void enterReturnDate(String dt)
	{
		returnDate.clear();
		returnDate.sendKeys(dt);
	}
	public void clickOnTravellersDropDown()
	{
		travellersDropDown.click();
	}
	public void selectTraveller(int a, int c,int i )
	{
		wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.visibilityOf(adults)).clear();
		adults.sendKeys(String.valueOf(a));
		wait.until(ExpectedConditions.visibilityOf(child)).clear();
		child.sendKeys(String.valueOf(c));
		wait.until(ExpectedConditions.visibilityOf(infant)).clear();
		infant.sendKeys(String.valueOf(i));

	}
	public void clickSearch()
	{
		searchButton.click();
	}
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	public void clickOnFlightsTab()
	{
		flightsTab.click();
	}
	@SuppressWarnings("deprecation")
	public void transaleToEnglish()
	{
		// This step is not defined in feature file. This is bypass for translating default Arabic page to English
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver);
		fWait.withTimeout(5,TimeUnit.SECONDS)
		.pollingEvery(1,TimeUnit.SECONDS)
		.ignoring(ElementNotInteractableException.class);

		((WebElement) fWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[1]/div[2]/div[2]/ul[1]/li[1]/a[1]/*[1]")))).click();
		((WebElement) fWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[1]/div[2]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]")))).click();
	}

}

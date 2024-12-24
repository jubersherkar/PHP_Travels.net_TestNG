package com.snd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css  = "input[placeholder='name@example.com'][name='email']")
	private WebElement txt_userName;

	@FindBy(xpath = "//input[@placeholder='******']")
	private WebElement txt_password;

	@FindBy(xpath = "//button[@id='submitBTN']//span")
	private WebElement btn_signIn;

	@FindBy(xpath = "//h4[normalize-space()='Invalid Login']")
	private WebElement lbl_errorMsg;
	
	
	public void setUserName(String userName) {

		txt_userName.sendKeys(userName);
	}

	public void setPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void clickSignInButton() {
		btn_signIn.click();
	}

	public String getErrorMessage() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(lbl_errorMsg));
		return lbl_errorMsg.getText();
	}

	public boolean getCurrentUrl() {
		wait = new WebDriverWait(driver, 10);
		if (wait.until(ExpectedConditions.urlToBe("https://phptravels.net/dashboard")))
			return true;
		else
			return false;
	}
}

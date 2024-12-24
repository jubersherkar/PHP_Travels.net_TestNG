package com.snd.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.snd.pageObjects.LoginPage;
import com.snd.utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginPageSteps {
	TestContext testContext;
	LoginPage loginPage;

	private Logger log = LogManager.getLogger();

	public LoginPageSteps(TestContext context) {
		this.testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
	}

	@Given("User enter base url as {string}")
	public void user_enter_base_url_as(String string) {
	    testContext.getWebDriverManager().getDriver().get(string);
	}

	@When("User enteres user id as {string}")
	public void user_enteres_user_id_as(String string) {
		loginPage.setUserName(string);
		log.info("Entered user id");
	}

	@When("User enteres Password as {string}")
	public void user_enteres_password_as(String string) {
		loginPage.setPassword(string);
		log.info("Entered password");
	}

	@When("Click on login")
	public void click_on_login() {
		loginPage.clickSignInButton();
		log.info("Clicked on login button");
	}

	@Then("User should be logged in")
	public void user_should_be_logged_in() {

		Assert.assertTrue(loginPage.getCurrentUrl());
		log.info("Login successful");
	}

	@Then("User should be able to see error as {string}")
	public void user_should_be_able_to_see_error(String string) {
		Assert.assertEquals(loginPage.getErrorMessage(), string);
		log.info("Login failed error displayed");
	}
}

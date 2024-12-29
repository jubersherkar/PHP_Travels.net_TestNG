package com.snd.stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.snd.managers.FileReaderManager;
import com.snd.utilities.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	TestContext testContext;
	WebDriver driver;
	private Logger log = LogManager.getLogger();

	public Hooks(TestContext context) {
		this.testContext = context;
	}

	@Before()
	public void beforeScenario() {
		driver = testContext.getWebDriverManager().getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getWaitTime(),
				TimeUnit.SECONDS);
		log.info("Browser launched");
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) throws Exception {

		if (scenario.isFailed()) {
			String screenShotName = scenario.getName().replaceAll(" ", "_");
			final byte[] sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver())
					.getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(sourcePath, "image/png", screenShotName);
			log.info("Screenshot taken");
		}
	}

	@After(order = 0)
	public void quitBrowser() {
		testContext.getWebDriverManager().closeDriver();
		log.info("Browser closed");
	}
}

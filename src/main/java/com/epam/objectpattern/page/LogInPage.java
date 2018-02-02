package com.epam.objectpattern.page;

import static com.epam.objectpattern.constant.Constant.WEB_SITE_URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends AbstractPage {

	private static final Logger LOG = Logger.getLogger(LogInPage.class);

	@FindBy(xpath = "//input[@type='email'][@name='identifier']")
	// @CacheLookup
	private WebElement logInField;

	@FindBy(id = "identifierNext")
	// @CacheLookup
	private WebElement logInNextButton;

	public LogInPage(WebDriver driver) {
		super(driver);
	}

	public void openPage() {
		LOG.error("START ---- LogInPage.openPage() ---- ");
		driver.get(WEB_SITE_URL);
	}

	public void inputLogIn(String userLogin) {
		logInField.sendKeys(userLogin);
		logInNextButton.click();

	}

}

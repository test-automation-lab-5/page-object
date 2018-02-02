package com.epam.objectpattern.page;

import static com.epam.objectpattern.constant.Constant.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	private static final Logger LOG = Logger.getLogger(AbstractPage.class);
	public WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//--------------Additional --------------
	protected boolean isSearchElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	protected void waitForElementToLoad(WebElement element) {
		int secondsCount = 0;
		boolean isElementShownIndicator = isSearchElementDisplayed(element);
		while (!isElementShownIndicator && secondsCount < 10) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			secondsCount++;
			isElementShownIndicator = isSearchElementDisplayed(element);
		}
		if (!isElementShownIndicator) {
			throw new AssertionError("Element was not shown");
		}
	}
	

		public boolean isAlertPresent() {
			boolean foundAlert = false;
			WebDriverWait wait = new WebDriverWait(driver, ALERT_WAIT_TIME);
			try {
				wait.until(ExpectedConditions.alertIsPresent());
				foundAlert = true;
			} catch (TimeoutException eTO) {
				foundAlert = false;
			}
			return foundAlert;
		}
}

package com.epam.objectpattern.page;

import static com.epam.objectpattern.constant.Constant.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class InboxPage extends AbstractPage{
	private static final Logger LOG = Logger.getLogger(InboxPage.class);
	
	public InboxPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void openPage() {//Isn't tested
		LOG.error("START ---- InboxPage.openPage() ---- ");
		driver.get(INBOX_URL);
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
	}
	
	
}

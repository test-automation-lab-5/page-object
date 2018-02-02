package com.epam.objectpattern.page;

import static com.epam.objectpattern.constant.Constant.MESSAGE_TEXT;
import static com.epam.objectpattern.constant.Constant.WEB_SITE_URL;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SentPage extends AbstractPage {
	private static final Logger LOG = Logger.getLogger(SentPage.class);

	public SentPage(WebDriver driver) {
		super(driver);
	}

	public void openPage() {
		LOG.error("START ---- SentPage.openPage() ---- ");
		driver.get("https://mail.google.com/mail/u/0/#sent");
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
	}

	public boolean isMasageFound(String messageText) {
		List<WebElement> elementsDrafts = driver
				.findElements(By.xpath("//div[contains(text(),'" + String.format("%s", messageText) + "')]"));
		if (elementsDrafts.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}

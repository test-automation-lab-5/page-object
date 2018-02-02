package com.epam.objectpattern.page;

import static com.epam.objectpattern.constant.Constant.IS_LOGGED_IN_URL;
import static com.epam.objectpattern.constant.Constant.MESSAGE_SENT_TO;
import static com.epam.objectpattern.constant.Constant.MESSAGE_SUBJECT;
import static com.epam.objectpattern.constant.Constant.MESSAGE_TEXT;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.epam.objectpattern.steps.Steps;

public class StartPage extends AbstractPage {
	private static final Logger LOG = Logger.getLogger(StartPage.class);
	
	@FindBy(xpath = "//div[@role='navigation']/preceding-sibling::div//div[@role='button']")
	private WebElement composeButton;

	@FindBy(xpath = "//form[@enctype='multipart/form-data']//textarea[@name='to']")
	private WebElement sentToTextarea;

	@FindBy(xpath = "//form[@enctype='multipart/form-data']/following::table//div[@role='textbox']")
	@CacheLookup
	private WebElement messageTexbox;

	@FindBy(xpath = "//form[@enctype='multipart/form-data']//input[@name='subjectbox']")
	private WebElement subjectBox;

	public StartPage(WebDriver driver) {
		super(driver);
	}

	public boolean isOpened() {
		String ss = driver.getCurrentUrl();
		return ss.equals(IS_LOGGED_IN_URL);
	}

	private void openNewMessageForm() {
		composeButton.click();
	}

	public void craeteMessage(String messageSentTo, String messageSubject, String messageText) {
		LOG.error("START ---- StartPage.craeteMessage() ---- ");
		openNewMessageForm();
		sentToTextarea.sendKeys(messageSentTo);
		sentToTextarea.click();
		messageTexbox.click();
		Actions builder = new Actions(driver);
		builder.moveToElement(subjectBox).build().perform();
		subjectBox.sendKeys(messageSubject);
		builder.moveToElement(messageTexbox).click().sendKeys(messageText).perform();
		messageTexbox.sendKeys(Keys.ESCAPE);
		LOG.error("FINISH ---- StartPage.craeteMessage() ---- ");
	}

}



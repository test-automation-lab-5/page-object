package com.epam.objectpattern.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.objectpattern.driverfactory.DriverManager;
import com.epam.objectpattern.driverfactory.DriverManagerFactory;
import com.epam.objectpattern.driverfactory.DriverType;
import com.epam.objectpattern.page.*;
import static com.epam.objectpattern.constant.Constant.*;

import java.util.concurrent.TimeUnit;

public class Steps {
	private static final Logger LOG = Logger.getLogger(Steps.class);
	private WebDriver driver;
    private DriverManager driverManager;

	public Steps() {
	}

	public void loginGmail(String userLogin, String userPassword) {
		LOG.error("START ---- Steps.loginGmail() ---- ");
		LogInPage logInPage = new LogInPage(driver);
		logInPage.openPage();
		logInPage.inputLogIn(userLogin);
		PasswordPage passwordPage = new PasswordPage(driver);
		passwordPage.inputPassword(userPassword);
	}

	public void openSentMail() {
		LOG.error("START ---- Steps.openSentMail() ---- ");
		SentPage sentPage = new SentPage(driver);
		sentPage.openPage();
	}

	public boolean isUserLoggedIn() {
		LOG.error("START ---- Steps.isUserLoggedIn() ---- ");
		StartPage startPage = new StartPage(driver);
		return startPage.isOpened();
	}

	public void openDrafts() {
		LOG.error("START ---- Steps.openDrafts() ---- ");
		DraftsPage draftsPage = new DraftsPage(driver);
		draftsPage.openPage();
	}

	public void createDraft(String messageSentTo, String messageSubject, String messageText) {
		LOG.error("START ---- Steps.createDraft() ---- ");
		StartPage startPage = new StartPage(driver);
		startPage.craeteMessage(messageSentTo, messageSubject, messageText);

	}
	
	public boolean isMessageInDrafts(String messageText) {
		LOG.error("START ---- Steps.isMessageInDrafts() ---- ");
		DraftsPage draftsPage = new DraftsPage(driver);
		return draftsPage.isMasageFound(messageText);
		
	}

	public void sendMessageFromDrafts(String messageText) {
		LOG.error("START ---- Steps.sendMessageFromDrafts() ---- ");
		DraftsPage draftsPage = new DraftsPage(driver);
		draftsPage.openPage();
		draftsPage.sendMasageFound(messageText);
	}
	
	public boolean isMessageInSent(String messageText) {
		LOG.error("START ---- Steps.isMessageInSent() ---- ");
		SentPage sentPage = new SentPage(driver);
		return sentPage.isMasageFound(messageText);
		
	}
	
	public void initBrowser(DriverType driverType) {
		LOG.error("START ---- Steps.initBrowser() ---- ");
		//System.setProperty(DRIVER_TYPE, DRIVER_PATH);
		//this.driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(GLOBAL_WAIT_TIME, TimeUnit.SECONDS);
		
		driverManager = DriverManagerFactory.getInstance().getManager(driverType);
		this.driver = driverManager.getDriver();
		LOG.error("FINISH ---- Steps.initBrowser() ---- ");
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.close();		
		}

	}

	// --------------Getters and setters-------------
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	

}

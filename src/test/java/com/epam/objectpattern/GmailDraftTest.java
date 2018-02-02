package com.epam.objectpattern;

import static com.epam.objectpattern.constant.Constant.MESSAGE_SENT_TO;
import static com.epam.objectpattern.constant.Constant.MESSAGE_SUBJECT;
import static com.epam.objectpattern.constant.Constant.MESSAGE_TEXT;
import static com.epam.objectpattern.constant.Constant.USER_LOGIN;
import static com.epam.objectpattern.constant.Constant.USER_PASSWORD;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.objectpattern.driverfactory.DriverType;
import com.epam.objectpattern.steps.Steps;

import junit.framework.TestCase;


public class GmailDraftTest extends TestCase {
	private Steps steps;
	
	@BeforeClass(description = "init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser(DriverType.CHROME);
	}
	@Test
	public void userCanLoginTest() {
		steps.loginGmail(USER_LOGIN, USER_PASSWORD);
		assertTrue(steps.isUserLoggedIn());
	}

	@Test
	public void userCanCreateNewDraft() {
		steps.loginGmail(USER_LOGIN, USER_PASSWORD);
		steps.createDraft(MESSAGE_SENT_TO, MESSAGE_SUBJECT, MESSAGE_TEXT);
		steps.openDrafts();
		assertTrue(steps.isMessageInDrafts(MESSAGE_TEXT));
	}

	@Test
	public void draftSentLetterTest() {
		steps.loginGmail(USER_LOGIN, USER_PASSWORD);
		steps.createDraft(MESSAGE_SENT_TO, MESSAGE_SUBJECT, MESSAGE_TEXT);
		steps.sendMessageFromDrafts(MESSAGE_TEXT); 
		assertTrue(steps.isMessageInSent(MESSAGE_TEXT));
	}

	@AfterClass(description = "close browser")
	public void tearDownUserCanLogin() {
		steps.closeBrowser();
	}

}

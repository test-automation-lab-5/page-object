package com.epam.task2;

import com.epam.task2.consts.Consts;
import com.epam.task2.pageobjects.LoginPage;
import com.epam.task2.pageobjects.MailboxPage;
import com.epam.task2.preferences.Preferences;
import com.epam.task2.preferences.PreferencesLoadException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TestGmail {
    private static final Logger log = Logger.getLogger(TestGmail.class);

    private WebDriver driver = null;

    @BeforeClass
    public void before() throws IOException, PreferencesLoadException {
        log.info("Init preferences");
        Preferences.loadPreferences(Consts.CONTS_PROPERTY_FILE_NAME);
        log.info("Preferences init complete");
        log.info("Init driver");
        System.setProperty(Preferences.preferencesTestGmail.getDriverType(), Preferences.preferencesTestGmail.getDriverURL());
        driver = new ChromeDriver() {
            {
                manage().timeouts().implicitlyWait(Preferences.preferencesTestGmail.getImplicitlyWait(), TimeUnit.SECONDS);
            }
        };
        log.info("Driver init complete");
    }

    @Test
    public void loginCheckDeleteUndo() {
        log.info("LoginCheckDeleteUndo start");
        LoginPage loginPage = new LoginPage(driver);
        log.info("Open browser page");
        loginPage.openPage();
        log.info("Type mail");
        loginPage.typeMail(Preferences.preferencesTestGmail.getUserMail());
        log.info("Type password");
        loginPage.typePassword(Preferences.preferencesTestGmail.getUserPassword());
        log.info("Wait mailbox load");
        MailboxPage mailboxPage = new MailboxPage(driver);
        mailboxPage.waitPageLoad();
        log.info("Select 3 messages from inbox using checkboxes");
        List<String> deletedId = mailboxPage.checkNVisibleCheckboxes(Preferences.preferencesTestGmail.getElementsCount());
        log.info("Click on delete button");
        mailboxPage.clickVisibleDeleteButton();
        log.info("Click on undo button");
        mailboxPage.clickUndoLink();
        log.info("Verify that messages are not deleted");
        mailboxPage.waitUndoDone();
        Assert.assertTrue(mailboxPage.getIdsOfFirstNVisibleMails(Preferences.preferencesTestGmail.getElementsCount()).equals(deletedId));
    }

    @AfterClass
    public void after() {
        if (!Objects.isNull(driver)) {
            log.info("Close driver");
            driver.close();
            driver.quit();
        }
    }
}

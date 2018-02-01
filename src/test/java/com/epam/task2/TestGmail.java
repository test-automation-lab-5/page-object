package com.epam.task2;

import com.epam.task2.pageobjects.LoginPage;
import com.epam.task2.pageobjects.MailboxPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TestGmail {
    private static final Logger log = Logger.getLogger(TestGmail.class);

    private final static String USER_MAIL = "mixer.log4j@gmail.com";
    private final static String USER_PASSWORD = "Kids12345a";
    private final static int ELEMENTS_COUT = 3;

    private WebDriver driver = null;

    @BeforeClass
    public void before() {
        log.info("Init driver");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver() {
            {
                manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        };
        log.info("Init complete");
    }

    @Test
    public void loginCheckDeleteUndo() {
        log.info("LoginCheckDeleteUndo start");
        LoginPage loginPage = new LoginPage(driver);
        log.info("Open browser page");
        loginPage.openPage();
        log.info("Type mail");
        loginPage.typeMail(USER_MAIL);
        log.info("Type password");
        loginPage.typePassword(USER_PASSWORD);
        log.info("Wait mailbox load");
        MailboxPage mailboxPage = new MailboxPage(driver);
        mailboxPage.waitPageLoad();
        log.info("Select 3 messages from inbox using checkboxes");
        List<String> deletedId = mailboxPage.checkNVisibleCheckboxes(ELEMENTS_COUT);
        log.info("Click on delete button");
        mailboxPage.clickVisibleDeleteButton();
        log.info("Click on undo button");
        mailboxPage.clickUndoLink();
        log.info("Verify that messages are not deleted");
        mailboxPage.waitUndoDone();
        Assert.assertTrue(mailboxPage.getIdsOfFirstNVisibleMails(ELEMENTS_COUT).equals(deletedId));
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

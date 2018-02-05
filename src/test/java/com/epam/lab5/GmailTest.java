package com.epam.lab5;

import com.epam.lab5.pageobjects.ComposePage;
import com.epam.lab5.pageobjects.DraftsPage;
import com.epam.lab5.pageobjects.InboxPage;
import com.epam.lab5.pageobjects.LoginPage;
import com.epam.lab5.propdata.DriverDataReader;
import com.epam.lab5.propdata.LoginDataReader;
import com.epam.lab5.testdata.TestDataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class GmailTest{

    private WebDriver driver;
    private LoginPage loginPage;
    private InboxPage inboxPage;
    private ComposePage composePage;
    private DraftsPage draftsPage;
    private LoginDataReader loginDataReader;
    private TestDataReader testDataReader;


    @BeforeClass
    public void setUp() throws IOException {
        DriverDataReader driverDataReader = new DriverDataReader();;
        System.setProperty(driverDataReader.getChromeDriver(),driverDataReader.getDriverPath());

        loginPage = new LoginPage();
        inboxPage = new InboxPage();
        composePage = new ComposePage();
        draftsPage = new DraftsPage();
        loginDataReader=new LoginDataReader();
        testDataReader=new TestDataReader();
    }

    @Test
    public void gmailTest(){
        loginPage.openLoginPage(loginDataReader.getMailLink());
        loginPage.enterEmail(loginDataReader.getMailAddress());
        loginPage.enterPassword(loginDataReader.getMailPassword());

        System.out.println(loginPage.exists());





        inboxPage.clickComposeButton();
        composePage.enterMailTo(testDataReader.getToFieldValue());
        composePage.enterMailSubject(testDataReader.getSubjectFieldValue());
        composePage.enterMailMessage(testDataReader.getMessageFieldValue());
        composePage.closeComposeWindow();
        draftsPage.openDraftsPage();
        assertEquals(testDataReader.getSubjectFieldValue(),
                draftsPage.getDraftMailWithSubject(testDataReader.getSubjectFieldValue()).getText());
        draftsPage.clickDraftMailWithSubject(testDataReader.getSubjectFieldValue());
        composePage.sendMail();
    }

    @AfterClass
    public void closeDriver(){
        driver.close();
    }




}

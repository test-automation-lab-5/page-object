package com.epam.lab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleTest {

    private static final String EMAIL = "annrusnaktest12345@gmail.com";
    private static final String PASS = "annatest123";
    private static final String SUBJECT_TO_CHECK = "HomePod. The new sound of home.";
    private static final String URL = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
    private WebDriver webDriver;

    @BeforeMethod
    public void setupDriver() {
        webDriver = WebDriverFactory.getInstance( "firefox" );
        webDriver.manage().timeouts().implicitlyWait( 45, TimeUnit.SECONDS );
    }

    @Test
    public void gmailTest() {
        WebDriverWait wait = new WebDriverWait( webDriver, 20 );
        webDriver.get( URL );
        webDriver.manage().window().maximize();
        GmailLoginPage gmailLoginPage = new GmailLoginPage( webDriver );
        gmailLoginPage.enterEmailClickNextButton( EMAIL );
        wait.until( ExpectedConditions.elementToBeClickable( gmailLoginPage.passwordField() ) );
        gmailLoginPage.enterPasswordClickNextButton( PASS );
        GmailMainPage gmailMainPage = new GmailMainPage( webDriver );
        gmailMainPage.selectCheckboxes( 3 );
        wait.until( ExpectedConditions.elementToBeClickable( gmailMainPage.delete() ) );
        gmailMainPage.deleteEmails();
        gmailMainPage.undoDeleting();
        wait.until( ExpectedConditions.elementToBeClickable( gmailMainPage.deleteCanceled() ) );

        Assert.assertEquals(1, gmailMainPage.expectedResult( SUBJECT_TO_CHECK ) );

    }

    @AfterMethod
    public final void tearDown() {
        webDriver.quit();
    }
}

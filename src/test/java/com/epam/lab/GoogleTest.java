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

    private WebDriver webDriver;
    private ReadProperties data = new ReadProperties();

    @BeforeMethod
    public void setupDriver() {

        data.readPropertiesFile( "dataFile.properties" );
        webDriver = WebDriverFactory.getInstance( data.getPropertyValue( "browser" ) );
        WebDriverWait wait = new WebDriverWait( webDriver, 20 );
        webDriver.manage().timeouts().implicitlyWait( 45, TimeUnit.SECONDS );

        webDriver.get( data.getPropertyValue( "url" ));
        webDriver.manage().window().maximize();

        GmailLoginPage gmailLoginPage = new GmailLoginPage( webDriver );
        gmailLoginPage.enterEmailClickNextButton( data.getPropertyValue( "email" ) );
        wait.until( ExpectedConditions.elementToBeClickable( gmailLoginPage.passwordField() ) );

        gmailLoginPage.enterPasswordClickNextButton( data.getPropertyValue( "password" ) );
    }

    @Test
    public void gmailTest() {
        data.readPropertiesFile( "dataFile.properties" );
        WebDriverWait wait = new WebDriverWait( webDriver, 20 );
        GmailMainPage gmailMainPage = new GmailMainPage( webDriver );
        gmailMainPage.selectCheckboxes( 3 );
        wait.until( ExpectedConditions.elementToBeClickable( gmailMainPage.delete() ) );
        gmailMainPage.deleteEmails();
        gmailMainPage.undoDeleting();
        wait.until( ExpectedConditions.elementToBeClickable( gmailMainPage.deleteCanceled() ) );
        Assert.assertEquals( gmailMainPage.expectedResult( data.getPropertyValue( "subjectCheck" ) ), 1 );

    }

    @AfterMethod
    public final void tearDown() {
        webDriver.quit();
    }
}

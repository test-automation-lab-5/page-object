package com.epam.lab.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailTest {
private static WebDriver driver;
    @BeforeClass
    public void launch() {
        driver= DriverObject.getDriver();
        }

    @Test
    public void testGmail() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get(ReadPropertyFile.readProperties("signInURL"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadPropertyFile.readProperties("email"));
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getPasswordInput()));
        loginPage.setPassword(ReadPropertyFile.readProperties("password"));
        loginPage.openGmail();

        GmailPage gmailPage = new GmailPage(driver);
        gmailPage.sendMessage(ReadPropertyFile.readProperties("receiver"), ReadPropertyFile.readProperties("subject"), ReadPropertyFile.readProperties("message"));
        gmailPage.goToSentFolder();

        gmailPage.removeLetter();
        wait.until(ExpectedConditions.elementToBeClickable(gmailPage.getConfirmDeleteButton()));
        gmailPage.confirmRemove();

        gmailPage.goToTrash();
        Assert.assertEquals(ReadPropertyFile.readProperties("subject"), gmailPage.getSubject());
           }
    @AfterClass
    public static void quitBrowser(){
        driver.quit();
    }
}


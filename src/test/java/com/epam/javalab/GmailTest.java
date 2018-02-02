package com.epam.javalab;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailTest {
    private final static String login = "olenkatestepam@gmail.com";
    private final static String Password = "testepam";
    private WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = WebDriverFactory.getInstance();
        webDriver.manage().window().maximize();
        webDriver.get("https://gmail.com");
    }

    @Test(priority = 1)
    public void testLoginPage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterLogin(login);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage.enterPassword(Password);
    }

    @Test(priority = 2)
    public void testMessageManipulation() {
        webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        MessageManipulation message = new MessageManipulation(webDriver);
        message.selectedMessages(3);
        message.clicMoreButton();
        message.addStarToMessage();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        message.goToStarredSection();
        message.selectStarredMessages(3);
        message.validateStaring();
    }

    @AfterClass
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}

package edu.epam.seleniumexample;


import edu.epam.seleniumexample.pages.LettersPage;
import edu.epam.seleniumexample.pages.LoginPage;
import edu.epam.seleniumexample.pages.MainPage;
import edu.epam.seleniumexample.pages.PasswordPage;
import edu.epam.seleniumexample.utils.BrowserDriver;
import edu.epam.seleniumexample.utils.PropertyContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimpleTest {

    @BeforeTest
    public void init() {
        PropertyContainer.loadProperties();
        BrowserDriver.createDriver(PropertyContainer.driverType, PropertyContainer.driverPath);
    }

    @AfterTest
    public void closeDriver() {
        BrowserDriver.getDriver().quit();
    }

    @Test
    public void mainPageTest() {
        WebDriver driver = BrowserDriver.getDriver();
        driver.get(PropertyContainer.startPage);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterLogin(PropertyContainer.login);

        PasswordPage passwordPage = new PasswordPage(driver);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        passwordPage.enterPassword(PropertyContainer.password);

//        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        LettersPage lettersPage = new LettersPage(driver);
        List<String> markedTitlesListOnMain = lettersPage.markImportantLetterAndGetMarkedTitles(3);

        lettersPage.clickImportantLettersButton();

            WebElement tmp = driver.findElement(By.xpath("//div[contains(@role,'main')]//span[contains(@class,'bog')]"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOf(tmp));

        List<String> markedTitlesListOnImportant = lettersPage.getImportantLetterTitle();
        // check result
        Assert.assertEquals(markedTitlesListOnImportant, markedTitlesListOnMain);

    }
}

package edu.epam.seleniumexample;


import edu.epam.seleniumexample.pages.LettersPage;
import edu.epam.seleniumexample.pages.LoginPage;
import edu.epam.seleniumexample.pages.MainPage;
import edu.epam.seleniumexample.pages.PasswordPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimpleTest {
    private WebDriver driver;

    @BeforeTest
    public void initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/gmail/about");
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void mainPageTest() {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.clickSignInButton();

        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.enterLogin("chkirchyk");

        PasswordPage passwordPage = new PasswordPage(this.driver);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        passwordPage.enterPassword("strilka27");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        LettersPage lettersPage = new LettersPage(this.driver);
        List<String> markedTitlesListOnMain = lettersPage.markImportantLetterAndGetMarkedTitles(3);

        lettersPage.clickImportantLettersButton();

            WebElement tmp = driver.findElement(By.xpath("//div[contains(@role,'main')]//span[contains(@class,'bog')]"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOf(tmp));

        List<String> markedTitlesListOnImportant = lettersPage.getImportantLetterTitle();
        // check result
        Assert.assertEquals(markedTitlesListOnImportant, markedTitlesListOnMain);

    }
}

package epam.com.pomgmaltest.tests;

import epam.com.pomgmail.pages.GmailHomePage;
import epam.com.pomgmail.pages.GmailLoginPage;
import epam.com.pomgmail.pages.GmailPasswordPage;
import epam.com.pomgmail.pages.ModelProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class POMGmailTest {
    private static WebDriver driver;
    private static GmailHomePage homePage;
    ModelProperties model = new ModelProperties();

    @BeforeClass
    public void setUpDriver() {
        model.setProperties();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(model.getUrl());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        homePage = new GmailHomePage();
    }

    @Test
    public void loginAndPasswordTest() throws InterruptedException {
        GmailLoginPage loginPage = new GmailLoginPage();
        loginPage.initElements(driver);
        loginPage.enterLoginAndSubmit(model.getLogin());

        GmailPasswordPage passwordPage = new GmailPasswordPage();
        passwordPage.initElements(driver);
        passwordPage.enterPasswordAndSubmit(model.getPassword());

        Assert.assertEquals("Gmail", driver.getTitle(), "Title not works.");

        WebDriverWait wait;
        homePage.initElements(driver);
        homePage.setMessageImportant();
        homePage.getInboxSubject(driver);
        List<String> titleList = homePage.getInboxSubject(driver);
        Thread.sleep(5000);
        homePage.clickImportantLink();
        Thread.sleep(2000);
        homePage.checkMessages(driver);
        homePage.getImportantSubject(driver);
        List<String> verifyList = homePage.getImportantSubject(driver);

        Assert.assertTrue(titleList.containsAll(verifyList), "Letters aren't present in Important.");

        wait = new WebDriverWait(driver, 20);
        homePage.clickDeleteAndMoreLinks();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.clickTrashLink()));
        homePage.clickTrashLink();
        Thread.sleep(2000);
        homePage.getDeletedSubject();
        List<String> deletedList = homePage.getDeletedSubject();

        Assert.assertTrue(deletedList.containsAll(titleList),"Wasn't deleted.");
    }
}

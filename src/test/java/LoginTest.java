/*1 Work with WebElement(s) ONLY inside page-object classes
2 Try to use abstract class while implementing page-objects
3 Use TestNG instead JUnit
4 Consider using one of GoF petterns for creating driver instance(s)
5 Tests should be triggered from command line with "mvn clean test" command (Surefire plugin could be used for these purposes
 http://maven.apache.org/surefire/maven-surefire-plugin/examples/inclusion-exclusion.html)*/


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void open() {

        GlobalConfiguration.loadProperties();
        GlobalConfiguration.loadData();
        System.setProperty(GlobalConfiguration.NAME_DRIVER, GlobalConfiguration.PATH_DRIVER);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 40);

    }

    @Test
    public void composeMail() {
        //  1.Open gmail & login
        driver.navigate().to(GlobalConfiguration.URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeLogin(GlobalConfiguration.MAIL);
        PasswordPage passwordPage = new PasswordPage(driver);
        passwordPage.typePassword(GlobalConfiguration.PASSWORD);
        //2,3.Click on compose button Enter incorrect email in “to” field, fill “subject”/”message” fields & press “send” button
        MailPage mailPage = new MailPage(driver);
        mailPage.typeMessage(GlobalConfiguration.INCORRECT_MAIL, GlobalConfiguration.SUBJECT, GlobalConfiguration.MESSAGE);
        mailPage.submitMessage();
        //4.Verify that warning message appears
        assertTrue(mailPage.verifyAlertMessage().isEnabled());
        mailPage.clickAlertMessage();
        //5.Click “OK” & enter correct email address & click send
        mailPage.typeCorrectMessage(GlobalConfiguration.TARGET_MAIL);
        mailPage.submitMessage();
        // 6.Verify that message is moved to “Sent mail” folder
        assertEquals(GlobalConfiguration.TARGET_MAIL, mailPage.checkSentMail());
     }

    @AfterClass
    public static void close() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}

package Task2;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import static junit.framework.TestCase.assertNotNull;
public class TestTask2 {
    private static WebDriver driver;
    private static String DRIVER_PATH = "src/test/resources/chromedriver.exe";
    private static String URL = "http://mail.google.com";
    private static String EMAIL = "hnatko2@gmail.com";
    private static String PASSWORD = "hnatko222";
    private static String ADDRESSE = "kristinabilokura@gmail.com";
    private static String SUBJECT = "Selenium";
    private static String MESSAGE = "Test[0]";
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @BeforeClass
    public static void open() {
        System.setProperty("webdriver.chrome.driver",DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void simpleLoginTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get(URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeLogin(EMAIL);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getPassword()));
        loginPage.typePassword(PASSWORD);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickmessage();
        mainPage.typeReseiver(ADDRESSE);
        mainPage.typeSubject(SUBJECT);
        mainPage.typeContent(MESSAGE);
        mainPage.ready();
        mainPage.clicklinkSentMessage();
        assertNotNull(mainPage.correct(ADDRESSE,driver));
        Thread.sleep(1000);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(mainPage.getcheckboxVisible()));
        mainPage.clickchechbox();
        mainPage.clickDelete();
        mainPage.clickOKButton();
        try {
            mainPage.correct(ADDRESSE,driver);
            Assert.fail("expecting NoSuchElementException here");
        } catch (Exception e) {
        }
    }
    @AfterClass
    public static void quit(){
        driver.quit();
    }
}

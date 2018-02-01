package Task2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.fail;

public class TestTask2 {
    private static WebDriver driver;
    private static String DRIVER_PATH = "src/test/resources/chromedriver.exe";
    private static String URL = "http://mail.google.com";
    private static String EMAIL = "hnatko2@gmail.com";
    private static String PASSWORD = "hnatko222";
    private static String ADDRESSE = "kristinabilokura@gmail.com";
    private static String SUBJECT = "Selenium";
    private static String MESSAGE = "Test[0]";
    @BeforeClass
    public static void open() {
        System.setProperty("webdriver.chrome.driver",DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void simpleLoginTest()  throws InterruptedException {
        driver.get(URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeLogin(EMAIL);
        (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(loginPage.getPassword()));
        loginPage.typePassword(PASSWORD);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickmessage();
        mainPage.typeReseiver(ADDRESSE);
        mainPage.typeSubject(SUBJECT);
        mainPage.typeContent(MESSAGE);
        mainPage.ready();
        mainPage.clicklinkSentMessage();
        Assert.assertNotNull(mainPage.correct(ADDRESSE,driver));
        Thread.sleep(1000);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(mainPage.getcheckboxVisible()));
        mainPage.clickchechbox();
        mainPage.clickDelete();
        try {
            mainPage.correct(ADDRESSE,driver);
            fail("FAIL");
        } catch (Exception ex) {
        }
    }
    @AfterClass
    public static void quit(){
        driver.quit();
    }
}

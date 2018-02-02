import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailLoginPageTest {
    private static WebDriver driver;


    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = DriverSingleton.getInstance();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/signin");

    }


    /*public static String getMyProperty(String property){
        Properties properties = null;

        try (InputStream inputStream = GmailLoginPageTest.class.getClassLoader().getResourceAsStream("string.properties")) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }*/


    @Test(priority=0)
    public void testLogin () {


        GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);

        String gmailAddress = "olenayurkiv2017@gmail.com";
        gmailLoginPage.setGmailAddress(gmailAddress);
        //gmailLoginPage.setGmailAddress(getMyProperty("gmailAddress"));
        gmailLoginPage.pressAddressNextButton();
        String gmailPassword = "0633787Mm";
        gmailLoginPage.setGmailPassword(gmailPassword);
        gmailLoginPage.pressPasswordNextButton();
        gmailLoginPage.goToGmail();
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("olenayurkiv.2017@gmail.com"));

    }

    @Test(priority=1)
    public void sendWrongEmail () {
        GmailHomePage gmailHomePage = new GmailHomePage(driver);
        String emailSubject="Email subject";
        String toMailIdWrong ="ole";
        //String toMailId ="olenayurkiv2017@gmail.com";
        String mailBody ="Mailbody";
        gmailHomePage.pressComposeButton();
        gmailHomePage.pressExpandWindow();
        gmailHomePage.setToAddress(toMailIdWrong);
        gmailHomePage.setGmailSubject(emailSubject);
        gmailHomePage.setGmailBody(mailBody);
        gmailHomePage.pressSendButton();


        GmailAlertPage gmailAlertPage = new GmailAlertPage(driver);
        String expectedError= "Проверьте правильность ввода всех адресов.";
        String actualError= gmailAlertPage.getAlertMessage();
        System.out.println(String.format("Error message: %s", actualError));
        gmailAlertPage.pressOkButton();
        Assert.assertTrue(actualError.contains(expectedError));


    }

    @Test(priority=2)
    public void sendValidEmail () {
        GmailHomePage gmailHomePage   = new GmailHomePage(driver);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", gmailHomePage.trashButton);
        String emailSubject="Email subject";
        String toMailId ="olenayurkiv2017@gmail.com";
        String mailBody ="Mailbody";

        gmailHomePage.pressComposeButton();
        gmailHomePage.pressExpandWindow();
        gmailHomePage.setToAddress(toMailId);
        gmailHomePage.setGmailSubject(emailSubject);
        gmailHomePage.setGmailBody(mailBody);
        gmailHomePage.pressSendButton();

        gmailHomePage.goToSentEmails();
        gmailHomePage.verifySendingEmail();



    }

    @AfterClass
    public static void cleanUp(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }

    }
}

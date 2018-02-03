import main.ComposeButtonClick;
import main.DraftsPage;
import main.LetterWindowPage;
import main.LoginPage;
import org.apache.http.util.Asserts;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import properties.DataProp;

import java.io.IOException;

public class GmailTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private DraftsPage draftsPage;
    private LetterWindowPage letterWindowPage;
    private ComposeButtonClick composeButtonClick;
    private DataProp dataProp;
    private String subject, message;

    @BeforeClass
    public void setUp() throws IOException {
        dataProp = new DataProp();
        System.setProperty(dataProp.driver(), dataProp.driverPath());

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        draftsPage = new DraftsPage(driver);
        letterWindowPage = new LetterWindowPage(driver);
        composeButtonClick = new ComposeButtonClick(driver);
        subject = dataProp.generateSubject();
        message = dataProp.generateMessage();
    }

    @Test
    public void sendLetterFromDraftsTest() {
        loginPage.loadLoginPage(dataProp.getURL());
        loginPage.enterEmailAndClickNext(dataProp.getMail());
        loginPage.enterPasswordAndClickNext(dataProp.getPassword());

        composeButtonClick.clickComposeButton();

        letterWindowPage.waitUntilBeClickable(5);
        letterWindowPage.enterTo(dataProp.getMailTo());
        letterWindowPage.enterCc(dataProp.getMailCc());
        letterWindowPage.enterBcc(dataProp.getMailBcc());
        letterWindowPage.enterSubject(subject);
        letterWindowPage.enterMessage(message);
        letterWindowPage.closeAndSaveLetter();

        draftsPage.openDrafts();
        draftsPage.waitForDraftsLoad();
        draftsPage.openLetterFromDraftsWithSameSubject(subject);

        letterWindowPage.sendLetter();

        Assert.assertEquals(letterWindowPage.getSubject(), subject);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

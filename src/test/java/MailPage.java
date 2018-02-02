import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage {

    @FindBy(xpath = "//*[@class='z0']")
    private WebElement composeButton;

    @FindBy(name = "to")
    private WebElement senderMailField;

    @FindBy(name = "subjectbox")
    private WebElement subjectMailField;

    @FindBy(xpath = "//*[@role=\"textbox\"]")
    private WebElement messageMailField;


    @FindBy(xpath = "//div[@class='J-J5-Ji btA']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement alertOkButton;

    @FindBy(xpath = "//div[@class='aoD hl']")
    private WebElement composeMailField;


    @FindBy(css = ".vM")
    private WebElement closeSenderMailButton;

    @FindBy(css = ".ag")
    private WebElement sentMailFolderButton;

    /* @FindBy(xpath="//div[@class='BltHke nH oy8Mbf'][@role='main']")
     private WebElement openSentMailButton;
 */
    @FindBy(css = ".g2")
    private WebElement lastMessageButton;

    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void typeMessage(String incorrectMessage, String subject, String message) {
        composeButton.click();
        senderMailField.sendKeys(incorrectMessage);
        subjectMailField.sendKeys(subject);
        messageMailField.sendKeys(message);

    }

    public WebElement verifyAlertMessage() {
        return alertOkButton;
    }

    public void clickAlertMessage() {
        alertOkButton.click();
    }

    public void typeCorrectMessage(String correctMessage) {
        composeMailField.click();
        closeSenderMailButton.click();
        senderMailField.sendKeys(correctMessage);
    }


    public void submitMessage() {
        submitButton.click();
    }

    public String checkSentMail() {
        sentMailFolderButton.click();
        // openSentMailButton.click();
        lastMessageButton.click();
        return lastMessageButton.getAttribute("email");

    }
}

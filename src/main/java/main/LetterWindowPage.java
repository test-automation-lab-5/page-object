package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetterWindowPage extends AbstractGmailPage {

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement inputTo;

    @FindBy(xpath = "//span[@class='aB gQ pE']")
    private WebElement cc;

    @FindBy(xpath = "//textarea[@name='cc']")
    private WebElement inputCc;

    @FindBy(xpath = "//span[@class='aB  gQ pB']")
    private WebElement bcc;

    @FindBy(xpath = "//textarea[@name='bcc']")
    private WebElement inputBcc;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement subjectInput;

    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private WebElement messageTextArea;

    @FindBy(xpath = "//img[@alt='Close']")
    private WebElement closeAndSave;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    private WebElement sendButton;

    @FindBy(xpath = "//form[@method='POST']/input[@name='subject' and @type='hidden']")
    private WebElement hiddenSubjectInput;

    public LetterWindowPage(WebDriver driver) {
        super(driver);
    }

    public void enterTo(String to) {
        inputTo.sendKeys(to);
    }

    public void enterCc(String cc) {
        this.cc.click();
        inputCc.sendKeys(cc);
    }

    public void enterBcc(String bcc) {
        this.bcc.click();
        inputBcc.sendKeys(bcc);
    }

    public void closeAndSaveLetter() {
        closeAndSave.click();
    }

    public void enterSubject(String subject) {
        subjectInput.sendKeys(subject);
    }

    public void enterMessage(String message) {
        messageTextArea.sendKeys(message);
    }

    public void waitUntilBeClickable(int seconds) {
        waitUntilElementBeClickable(inputTo, seconds);
    }

    public void sendLetter() {
        sendButton.click();
    }

    public String getSubject() {
        if (hiddenSubjectInput.getAttribute("value").length() == 0) {
            return null;
        } else {
            return subjectInput.getAttribute("value");
        }
    }
}

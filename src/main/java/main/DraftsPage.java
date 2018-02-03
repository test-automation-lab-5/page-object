package main;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class DraftsPage extends AbstractGmailPage {

    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/#drafts']")
    private WebElement drafts;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement googleSearchInput;

    public DraftsPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public void openDrafts() {
        drafts.click();
    }

    public void waitForDraftsLoad() {
        waitUntilTextToBePresentInElement(googleSearchInput, "in:draft ");
    }

    public void openLetterFromDraftsWithSameSubject(String subject) {
        WebElement letter = driver.findElement(By.xpath("//table[@cellpadding='0']/tbody/tr/td[@class='xY a4W']/div/div/div/span[text()='" + subject + "']"));
        letter.click();
    }
}

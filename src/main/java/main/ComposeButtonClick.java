package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComposeButtonClick extends AbstractGmailPage {

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3' and @role='button']")
    private WebElement composeButton;

    public ComposeButtonClick(WebDriver driver) {
        super(driver);
    }

    public void clickComposeButton() {
        composeButton.click();
    }
}

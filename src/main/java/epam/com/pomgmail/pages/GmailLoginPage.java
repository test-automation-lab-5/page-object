package epam.com.pomgmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage extends InitElementsClass {
    @FindBy(xpath = "//input[contains(@type,'email')]")
    private WebElement loginInput;

    @FindBy(id = "identifierNext")
    private WebElement btnNext;

    public void initElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void enterLoginAndSubmit(String login){
        loginInput.sendKeys(login);
        btnNext.click();
    }
}

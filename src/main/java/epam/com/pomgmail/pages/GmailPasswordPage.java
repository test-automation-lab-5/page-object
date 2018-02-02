package epam.com.pomgmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPasswordPage extends InitElementsClass{
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(id = "passwordNext")
    private WebElement buttonNext;

    public void initElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void enterPasswordAndSubmit(String password){
        passwordInput.sendKeys(password);
        buttonNext.click();
    }
}

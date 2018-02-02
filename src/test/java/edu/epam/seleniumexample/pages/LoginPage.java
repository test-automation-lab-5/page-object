package edu.epam.seleniumexample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//*[@name='identifier']")
    private WebElement loginFild;

    @FindBy(css = ".RveJvd.snByac")
    private WebElement loginOkButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getLoginField() {
        return loginFild;
    }

    public void enterLogin(String login) {
        loginFild.sendKeys(login);
        loginOkButton.click();
    }
}

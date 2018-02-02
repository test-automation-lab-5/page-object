package edu.epam.seleniumexample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(id = "passwordNext")
    WebElement passwordEnterButton;

    public PasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
        passwordEnterButton.click();
    }

    public WebElement getPasswordField() {
        return passwordField;
    }
}

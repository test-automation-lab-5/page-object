package com.epam.javalab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement loginElement;

    @FindBy(id = "identifierNext")
    private WebElement loginNextButton;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordElement;

    @FindBy(id = "passwordNext")
    private WebElement passwordNextButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterLogin(String login) {
        loginElement.sendKeys(login);
        loginNextButton.click();
    }

    public void enterPassword(String password) {
        passwordElement.sendKeys(password);
        passwordNextButton.click();
    }
}
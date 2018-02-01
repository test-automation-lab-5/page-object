package com.epam.lab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage {

    @FindBy(xpath = "//*[@id='identifierId']")
    private WebElement enterEmailField;

    @FindBy(xpath = "//*[@id='identifierNext']/content/span")
    private WebElement enterEmailNextButton;

    @FindBy(xpath = ".//*[@id='password']//descendant::input")
    private WebElement passwordField;

    @FindBy(xpath = ".//*[@id='passwordNext']//descendant::span")
    private WebElement enterPasswordNextButton;


    public GmailLoginPage(WebDriver webDriver) {
        PageFactory.initElements( webDriver, this );
    }

    public void enterEmailClickNextButton(String email) {
        enterEmailField.sendKeys( email );
        enterEmailNextButton.click();
    }

    public void enterPasswordClickNextButton(String password) {
        passwordField.sendKeys( password );
        enterPasswordNextButton.click();
    }

    public WebElement passwordField() {
        return passwordField;
    }
}

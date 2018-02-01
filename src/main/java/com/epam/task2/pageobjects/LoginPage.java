package com.epam.task2.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@type='email']")
    private WebElement mailField;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void openPage(){
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
    }

    public void typeMail(String mail) {
        mailField.sendKeys(String.format("%s\n", mail));
    }

    public void typePassword(String password) {
        waitUntilBeClickable(passwordField).sendKeys(String.format("%s\n", password));
    }
}

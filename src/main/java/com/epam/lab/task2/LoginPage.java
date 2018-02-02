package com.epam.lab.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath="//input[@id='identifierId']")
    private WebElement emailInput;
    @FindBy(id = "identifierNext")
    private WebElement emailNext;
    @FindBy(xpath="//input[@name='password']")
    private WebElement passwordInput;
    @FindBy(id = "passwordNext")
    private WebElement passwordNext;
    @FindBy(className="WaidBe")
    private WebElement gmailPage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String email){
        emailInput.sendKeys(email);
        emailNext.click();
    }

    public WebElement getPasswordInput(){
        return passwordInput;
    }

    public void setPassword(String pass){
        passwordInput.sendKeys(pass);
        passwordNext.click();
    }

    public void openGmail(){
        gmailPage.click();
    }
}

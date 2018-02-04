package com.epam.lab.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

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
        super(driver);
    }

    public void login(String email){
        emailInput.sendKeys(email);
        emailNext.click();
    }


    public void setPassword(String pass){
        waitToBeClickable(passwordInput);
        passwordInput.sendKeys(pass);
        passwordNext.click();
    }

    public void openGmail(){
        gmailPage.click();
    }

}

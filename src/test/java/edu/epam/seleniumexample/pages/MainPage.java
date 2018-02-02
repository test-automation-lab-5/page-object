package edu.epam.seleniumexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//a[@class='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")
    private WebElement signInButton;

    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public WebElement getSignInButton() {
        return signInButton;
    }
}

package com.epam.lab5.pageobjects;

import com.epam.lab5.elements.Name;
import com.epam.lab5.elements.PageElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    private static final Logger log = Logger.getLogger(LoginPage.class);

    @FindBy(name = "identifier")
    @Name("Email input")
    private PageElement emailInput;

    @FindBy(name="password")
    @Name("Password input")
    private PageElement passwordInput;

    @FindBy(name = "asfasdfsdfasdfasd")
    @Name("Unexisting element")
    private PageElement unexistingElement;



    public void openLoginPage(String loginPageLink){
        driver.get(loginPageLink);
    }

    public void enterEmail(String email){
        emailInput.sendKeys(email+Keys.ENTER);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password+Keys.ENTER);
    }

    public boolean exists () {
        return unexistingElement.exists();
    }
}

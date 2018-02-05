package com.epam.lab5.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComposePage extends AbstractPage {

    private static final Logger log = Logger.getLogger(ComposePage.class);

    @FindBy(css = ".oj div textarea" )
    private WebElement mailToInput;

    @FindBy(name = "subjectbox")
    private WebElement mailSubjectInput;

    @FindBy(css = ".Ar.Au div")
    private WebElement mailMessageInput;

    @FindBy(css=".Ha")
    private WebElement composeWindowCloseButton;



    public void enterMailTo(String mailTo){
        mailToInput.sendKeys(mailTo);
        log.info("'To' field was filled in.");
    }

    public void enterMailSubject(String mailSubject){
        mailSubjectInput.sendKeys(mailSubject);
        log.info("'Subject' field was filled in.");
    }

    public void enterMailMessage(String mailMessage){
        mailMessageInput.sendKeys(mailMessage);
        log.info("'Mail Text' field was filled in.");
    }

    public void closeComposeWindow(){
        composeWindowCloseButton.click();
        log.info("'Compose' window was closed.");
    }


    public void sendMail(){
        mailMessageInput.sendKeys(Keys.CONTROL,Keys.ENTER);
        log.info("Mail from Draft was sent.");
    }


}

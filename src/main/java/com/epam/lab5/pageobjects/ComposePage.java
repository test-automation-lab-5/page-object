package com.epam.lab5.pageobjects;

import com.epam.lab5.elements.PageElement;
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
    private PageElement mailToInput;

    @FindBy(name = "subjectbox")
    private PageElement mailSubjectInput;

    @FindBy(css = ".Ar.Au div")
    private PageElement mailMessageInput;

    @FindBy(css=".Ha")
    private PageElement composeWindowCloseButton;



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

package com.epam.lab5.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends AbstractPage {

    private static final Logger log = Logger.getLogger(InboxPage.class);

    @FindBy(css = ".aic .z0 div")
    private WebElement composeButton;

    public void clickComposeButton() {
        composeButton.click();
        log.info("Compose button was clicked.");
    }
}

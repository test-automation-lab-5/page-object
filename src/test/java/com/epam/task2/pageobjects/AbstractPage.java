package com.epam.task2.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    WebDriver driver;
    private int timeOutInSeconds;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        timeOutInSeconds = 10;
        PageFactory.initElements(driver, this);
    }

    public void waitPageLoad() {
        getWait().until((ExpectedCondition<Boolean>) wd ->
                driver.getCurrentUrl().equals("https://mail.google.com/mail/#inbox"));
        getWait().until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public int getTimeOutInSeconds() {
        return timeOutInSeconds;
    }

    public void setTimeOutInSeconds(int timeOutInSeconds) {
        this.timeOutInSeconds = timeOutInSeconds;
    }

    protected WebElement waitUntilBeClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebDriverWait getWait() {
        return (new WebDriverWait(driver, timeOutInSeconds));
    }
}

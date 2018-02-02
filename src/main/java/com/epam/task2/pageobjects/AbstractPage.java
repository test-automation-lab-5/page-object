package com.epam.task2.pageobjects;

import com.epam.task2.preferences.Preferences;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    WebDriver driver;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void waitPageRedirectToURL(String pageUrl) {
        getWait().until((ExpectedCondition<Boolean>) wd ->
                driver.getCurrentUrl().equals(pageUrl));
    }

    protected void waitPageLoad() {
        getWait().until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    protected void waitUntilTrue(ExpectedCondition<Boolean> expectedCondition)
    {
        getWait().until(expectedCondition);
    }

    protected WebElement waitUntilBeClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebDriverWait getWait() {
        return (new WebDriverWait(driver, Preferences.preferencesTestGmail.getTimeOutInSeconds()));
    }
}
package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

class AbstractGmailPage {
    WebDriver driver;

    AbstractGmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    void waitUntilElementBeClickable(WebElement element, int seconds) {
        (new WebDriverWait(driver, seconds)).until(ExpectedConditions.elementToBeClickable(element));
    }

    void waitUntilTextToBePresentInElement(WebElement element, String text) {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }
}

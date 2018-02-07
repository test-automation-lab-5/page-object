package edu.epam.seleniumexample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    public AbstractPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}

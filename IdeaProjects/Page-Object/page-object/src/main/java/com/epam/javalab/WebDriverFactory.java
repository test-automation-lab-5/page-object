package com.epam.javalab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C://Program Files//Chrome Driver//chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }
}


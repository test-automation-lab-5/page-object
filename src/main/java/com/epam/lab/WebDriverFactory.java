package com.epam.lab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    public static WebDriver getInstance(String browser) {
        WebDriver webDriver;

        if (CHROME.equals( browser )) {
            System.setProperty( "webdriver.chrome.driver", "src/resourses/chromedriver.exe" );
            webDriver = new ChromeDriver();
        } else if (FIREFOX.equals( browser )) {
            System.setProperty( "webdriver.gecko.driver", "src/resourses/geckodriver.exe" );
            webDriver = new FirefoxDriver();
        } else throw new IllegalArgumentException( "Invalid browser property set in configuration file" );
        return webDriver;
    }
}


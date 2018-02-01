package com.epam.lab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    public static WebDriver getInstance(String browser) {
        WebDriver webDriver;

        if (CHROME.equals( browser )) {
            System.setProperty( "webdriver.chrome.driver", "src/resourses/chromedriver.exe" );
            webDriver = new ChromeDriver();
        } else if (FIREFOX.equals( browser )) {
            DesiredCapabilities capabilitiesFirefox = new DesiredCapabilities();
            capabilitiesFirefox.setCapability("marionette", false);
            webDriver = new FirefoxDriver(capabilitiesFirefox);
        } else throw new IllegalArgumentException( "Invalid browser property" );
        return webDriver;
    }
}


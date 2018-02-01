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
        ReadProperties data = new ReadProperties();
        data.readPropertiesFile( "prop.properties" );

        if (CHROME.equals( browser )) {
            System.setProperty( data.getPropertyValue( "chrome_driver" ), data.getPropertyValue( "chrome_path" ) );
            webDriver = new ChromeDriver();
        } else if (FIREFOX.equals( browser )) {
            DesiredCapabilities capabilitiesFirefox = new DesiredCapabilities();
            capabilitiesFirefox.setCapability("marionette", false);
            webDriver = new FirefoxDriver(capabilitiesFirefox);
        } else throw new IllegalArgumentException( "Invalid browser property" );
        return webDriver;
    }
}


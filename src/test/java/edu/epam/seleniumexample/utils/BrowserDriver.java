package edu.epam.seleniumexample.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserDriver {

    private static Integer IMPLICITLY_WAIT = 25;
    private static WebDriver driver;

    public static void createDriver(String driverType, String driverPath) {
        System.setProperty(driverType, driverPath);
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            if ("webdriver.chrome.driver".equals(PropertyContainer.driverType)) {
                driver = new ChromeDriver();
            }
            if ("webdriver.gecko.driver".equals(PropertyContainer.driverType)) {
                driver = new FirefoxDriver();
            }
           if(driver == null){
                throw new UnsupportedOperationException();
           }
        }
        return driver;
    }
}




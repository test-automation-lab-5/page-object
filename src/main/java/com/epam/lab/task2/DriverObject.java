package com.epam.lab.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverObject {

    private static WebDriver driver;

    DriverObject() {}

    public static void createDriver(){

        String driverURL = ReadPropertyFile.readProperties("driverURL");
        System.setProperty("webdriver.chrome.driver", driverURL);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        if (driver == null) {
        createDriver();
        }
        return driver;
    }
}


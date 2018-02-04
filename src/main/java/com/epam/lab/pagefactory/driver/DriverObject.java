package com.epam.lab.pagefactory.driver;

import com.epam.lab.pagefactory.propertyreader.ReadPropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverObject {

    private static WebDriver driver;

    DriverObject() {}

    private static void createDriver() throws IOException {
        ReadPropertyFile reader = new ReadPropertyFile();

        System.setProperty(reader.readDriverPath(), reader.readChromeDriver());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() throws IOException {
        if (driver == null) {
        createDriver();
        }
        return driver;
    }
}


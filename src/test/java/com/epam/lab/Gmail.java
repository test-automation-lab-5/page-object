package com.epam.lab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;



/*Task 5
        1. Open gmail & login
        2. Click on “compose” button
        3. Fill the next fields: to,subject & message
        4. Click on “save & close” button
        5. Go to the “draft” folder & open previously saved message
        6. Verify that all fields are saved correctly
        7. Press the “send” button*/


public class Gmail {
    private WebDriver driver;
    private Properties prop;
    private InputStream input;

    @Before
    public void init() {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");

        driver = new ChromeDriver();

        prop = new Properties();
        input = null;
        try {
            input = new FileInputStream("src/resources/config.properties");
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Test
    public void sendFromDrafts() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(prop.getProperty("mailLink"));

        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(prop.getProperty("mail") + Keys.ENTER);

        driver.findElement(By.name("password")).sendKeys(prop.getProperty("mailPassword") + Keys.ENTER);

        driver.findElement(By.xpath("//div[@class='z0']/div")).click();

        driver.findElement(By.className("vO")).sendKeys("vova_lvova@ukr.net");

        driver.findElement(By.className("aoT")).sendKeys("Test Selenium");

        driver.findElement(By.cssSelector("div[class='Am Al editable LW-avf'")).sendKeys("Hi!");

        driver.findElement(By.className("Ha")).click();

        driver.findElement(By.xpath("//span[@class='nU n1']")).click();

        (new WebDriverWait(driver, 5)).until
                (ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@name='q']"), "in:draft "));

        driver.findElement(By.xpath("//span[contains(text(),'Hi!')]")).click();

        driver.findElement(By.cssSelector("td[class='gU Up']")).click();

        assertNotNull(driver.findElement(By.xpath("//span[@class='ag a8k']")));
    }

    @After
    public void close() {
        driver.quit();
    }
}
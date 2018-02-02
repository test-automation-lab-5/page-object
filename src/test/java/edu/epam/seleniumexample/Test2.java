package edu.epam.seleniumexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test2 {

    @Test
    public void markImportentLettersInGMailTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new ChromeDriver();
        //      WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/gmail/about");
        driver.findElement(By.cssSelector(".gmail-nav__nav-link.gmail-nav__nav-link__sign-in")).click();

        driver.findElement(By.xpath("//*[@name='identifier']")).sendKeys("chkirchyk");
        driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")))
                .sendKeys("strilka27");
        driver.findElement(By.id("passwordNext")).click();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        List<WebElement> signs = driver.findElements(By.xpath("//tr[contains(@class,'zA')]//td[contains(@class,'WA xY')]"));
        List<WebElement> titles = driver.findElements(By.xpath("//div[@role='tabpanel']//tr[contains(@class,'zA')]//span[contains(@class,'bog')]"));
        List<String> expectedTitles = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            signs.get(i).click();
            expectedTitles.add(titles.get(i).getText());
        }

        WebElement importantLabel = driver.findElements(By.xpath("//div[contains(@class, 'TK')]//div[contains(@class, 'aim')]//a")).get(2);
        importantLabel.click();



        WebElement tmp = driver.findElement(By.xpath("//div[contains(@role,'main')]//span[contains(@class,'bog')]"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOf(tmp));

        List<WebElement> actualSpans = driver.findElements(By.xpath("//div[contains(@role,'main')]//span[contains(@class,'bog')]"));
        List<String> actualTitles = new ArrayList<String>();
        for (WebElement item : actualSpans) {
            actualTitles.add(item.getText());
        }
        Assert.assertEquals(actualTitles, expectedTitles);
        driver.quit();
    }
}

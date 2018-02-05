package com.epam.lab5.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DraftsPage extends AbstractPage {

    private static final Logger log = Logger.getLogger(DraftsPage.class);

    @FindBy(css = ".TN.GLujEb.aHS-bnq .aio.UKr6le span a")
    private WebElement draftsButton;

    private WebElement draftMailWithSubject;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public void openDraftsPage(){
        waitDraftsButtonVisibility();
        draftsButton.click();
        log.info("'Drafts' page was opened.");
    }

    public void clickDraftMailWithSubject(String mailSubject){
        getDraftMailWithSubject(mailSubject).click();
        log.info("Mail from Draft was opened.");
    }

    public WebElement getDraftMailWithSubject(String mailSubject){
        draftMailWithSubject=driver.findElement(By.xpath(String.format("//span[@class='bog'][text()='%s']",mailSubject)));
        return draftMailWithSubject;
    }

    private void waitDraftsButtonVisibility(){
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".TN.GLujEb.aHS-bnq .aio.UKr6le span a")));
    }

}

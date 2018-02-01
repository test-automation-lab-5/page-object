package com.epam.task2.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MailboxPage extends AbstractPage {
    @FindBy(xpath = "//div[@role='main']//div[@role='checkbox']")
    private WebElement visibleCheckbox;
    @FindBy(xpath = "//div[@role='main']//div[@role='checkbox']")
    private List<WebElement> visibleCheckboxes;
    @FindBy(xpath = "//div[@gh='mtb']//div[@act='10']")
    private WebElement visibleDeleteButton;
    @FindBy(id = "link_undo")
    private WebElement undoLink;
    @FindBy(xpath = "//div[@aria-live='assertive'][@aria-atomic='true']/div/div/span")
    private WebElement undoDone;


    public MailboxPage(WebDriver driver) {
        super(driver);
    }

    public List<String> checkNVisibleCheckboxes(int n) {
        waitUntilBeClickable(visibleCheckbox);
        visibleCheckboxes.stream().limit(Math.min(n,visibleCheckboxes.size())).forEach(WebElement::click);
        return getIdsOfFirstNVisibleMails(n);
    }

    public void waitPageLoad() {
        waitPageLoad("https://mail.google.com/mail/#inbox");
    }

    public void clickVisibleDeleteButton() {
        visibleDeleteButton.click();
    }

    public void clickUndoLink() {
        waitUntilBeClickable(undoLink).click();
    }

    public void waitUndoDone() {
        waitUntilBeClickable(undoDone);
    }

    public List<String> getIdsOfFirstNVisibleMails(int n) {
        return visibleCheckboxes.stream().limit(Math.min(n,visibleCheckboxes.size())).map(webElement-> webElement.getAttribute("id")).collect(Collectors.toList());
    }
}

package com.epam.javalab;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class MessageManipulation {
    @FindBy(xpath = "//div[@role='checkbox']")
    private WebElement checkbox;

    @FindBy(className = "bjy")
    private WebElement moreButton;

    @FindBy(xpath = "//div[text()='Add star']")
    private WebElement addStarButton;

    @FindBy(xpath = "//*[text()='Starred']")
    private WebElement starredSection;

    @FindBy(xpath = "//div[@act='10']")
    private WebElement deleteSection;

    @FindBy(className = "CJ")
    private WebElement moreSection;

    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/#trash']")
    private WebElement binSection;

    @FindBy(xpath = "//div[@role='checkbox']")
    private List<WebElement> messageList;

    @FindBy(xpath = "//div[@role='checkbox']")
    private List<WebElement> starredMessageList;

    @FindBy(xpath = "//div[@role='checkbox']")
    private List<WebElement> deleteMessageList;

    public MessageManipulation(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List selectedMessages(int count) {
        for (int i = 0; i < count; i++) {
            messageList.get(i).click();
        }
        return messageList.stream().map(x -> x.getAttribute("id")).collect(Collectors.toList());
    }

    public List selectStarredMessages(int count) {
        for (int i = 0; i < count; i++) {
            starredMessageList.get(i);
        }
        return starredMessageList.stream().map(x -> x.getAttribute("id")).collect(Collectors.toList());
    }

    public WebElement getCheckbox() {
        return checkbox;
    }

    public void clicMoreButton() {
        moreButton.click();
    }

    public void addStarToMessage() {
        addStarButton.click();
    }

    public void goToStarredSection() {
        starredSection.click();
    }

    public void goToDeleteSection() {
        deleteSection.click();
    }

    public void clickMoreSection() {
        moreSection.click();
    }

    public void goToBinSection() {
        binSection.click();
    }

    public void validateStaring() {
        Assert.assertEquals(messageList, starredMessageList);
    }

    public List selectDeletedMessages(int count) {
        for (int i = 0; i < count; i++) {
            deleteMessageList.get(i).click();
        }
        return deleteMessageList.stream().map(x -> x.getAttribute("id")).collect(Collectors.toList());
    }

    public void validateDeleting() {
        Assert.assertEquals(starredMessageList, deleteMessageList);
    }
}
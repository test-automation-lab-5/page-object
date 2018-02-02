package com.epam.lab.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GmailPage{

    @FindBy(xpath="//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement composeButton;
    @FindBy(xpath="//textarea[@name='to']")
    private WebElement receiver;
    @FindBy(xpath="//input[@name='subjectbox']")
    private WebElement subject;
    @FindBy(xpath="//div[@aria-multiline='true']")
    private WebElement message;
    @FindBy(css="div[data-tooltip*='Enter']")
    private WebElement enterButton;
    @FindBy(xpath="//a[@href='https://mail.google.com/mail/u/0/#sent']")
    private WebElement sentFolder;
    @FindBy(xpath="//div[@role='main']//div[@role='checkbox']")
    private WebElement checkbox;
    @FindBy(xpath="//div[@gh='mtb']//div[@act='10']")
    private WebElement deleteButton;
    @FindBy(xpath = "//div[@role='alertdialog']//button[@name='ok']")
    private WebElement confirmDeleteButton;
    @FindBy(xpath = "//span[@role='button']")
    private WebElement moreButton;
    @FindBy(xpath="//a[@href='https://mail.google.com/mail/u/0/#trash']")
    private WebElement trashButton;
    @FindBy(xpath = "//*[@class='bog']//*[text()='Subject']")
    private WebElement subjectCheck;

    public GmailPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void sendMessage(String to, String sub, String mess){
        composeButton.click();
        receiver.sendKeys(to);
        subject.sendKeys(sub);
        message.sendKeys(mess);
        enterButton.click();
    }

    public void goToSentFolder(){
        sentFolder.click();
    }

    public void removeLetter(){
        checkbox.click();
        deleteButton.click();
    }
    public WebElement getConfirmDeleteButton(){
        return confirmDeleteButton;
    }
    public void confirmRemove(){
        confirmDeleteButton.click();
    }

    public void goToTrash(){
        moreButton.click();
        trashButton.click();
    }
    public String getSubject(){
        String subj = subjectCheck.getText();
        return subj;
    }
}

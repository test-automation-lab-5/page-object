package com.epam.lab.pagefactory.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPage extends AbstractPage{
    private Logger log = Logger.getLogger(GmailPage.class);
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
    @FindBy(xpath = "//span[@role='button'][@gh='mll']")
    private WebElement moreButton;
    @FindBy(xpath="//a[@href='https://mail.google.com/mail/u/0/#trash']")
    private WebElement trashButton;
    @FindBy(xpath = "//span[@class='bofITb']")
    private WebElement movedToTrashMessage;

    public GmailPage(WebDriver driver){
        super(driver);
    }

    public void sendMessage(String to, String sub, String mess){
        log.info("Composing Letter");
        waitToBeClickable(composeButton).click();
        receiver.sendKeys(to);
        subject.sendKeys(sub);
        message.sendKeys(mess);
        enterButton.click();
        log.info("Letter was sent");
        waitToBeClickable(sentFolder);
    }

    public void goToSentFolder(){
        sentFolder.click();
        waitToBeClickable(checkbox);
        }

    public void removeLetter(){
        waitToBeClickable(checkbox);
        log.info("Opened sent folder");
        checkbox.click();
        waitToBeClickable(deleteButton);
        log.info("Clicked on the checkbox");
        waitToBeClickable(deleteButton).click();
        log.info("Wait on removal");
        confirmDeleteButton.click();
        log.info("Confirmed removal");
    }

    public String getComposeCheck(){
        return composeButton.getText();
    }
    public String getMovedToTrashMessage(){
        return movedToTrashMessage.getText();
    }
}

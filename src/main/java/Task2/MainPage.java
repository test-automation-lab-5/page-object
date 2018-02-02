package Task2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath= "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement message;
    @FindBy(className= "vO")
    private WebElement receiver;
    @FindBy(xpath = "//input[@class='aoT']")
    private WebElement subject;
    @FindBy(xpath= "//div[@class='Am Al editable LW-avf']")
    private WebElement messageContent;
    @FindBy(xpath= "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    private WebElement readyToSend;
    @FindBy(xpath= "//a[@href='https://mail.google.com/mail/u/0/#sent']")
    private WebElement sentMessages;
    @FindBy(xpath= "//div[@role='main']//div[@role='checkbox']")
    private WebElement markCheckBox;
    @FindBy(xpath= "//div[@gh='tm']//div[@act='10']")
    private WebElement ClickDeleteIcon;
    @FindBy(name= "ok")
    private WebElement okmessage;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public WebElement correct(String receiver, WebDriver driver) {
        WebElement assertion = driver.findElement(By.xpath("//*[@email='" + String.format("%s", receiver) + "']"));
        return assertion;
    }
    public void clickmessage(){
        message.click();
    }
    public void typeMessage(String reciver,String subjectMesage,String message){
        receiver.sendKeys(reciver);
        subject.sendKeys(subjectMesage);
        messageContent.sendKeys(message);
        readyToSend.click();
    }
    public void clicklinkSentMessage(){
        sentMessages.click();
    }
    public WebElement getcheckboxVisible() {
        return markCheckBox;
    }
    public void clickchechbox(){
        markCheckBox.click();
    }
    public void clickDelete(){
        ClickDeleteIcon.click();
        okmessage.click();
    }
}
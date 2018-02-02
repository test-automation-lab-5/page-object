import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailHomePage  extends  AbstractPage {
    /*driver.findElement(By.xpath("//td//img[2]")).click();
        driver.findElement(By.className("vO")).sendKeys(tomailidWrong);
        driver.findElement(By.className("aoT")).sendKeys(emailsubject);
        driver.findElement(By.cssSelector("div[class='Am Al editable LW-avf']")).sendKeys(mailbody);
        driver.findElement(By.xpath("//div[text()='Отправить']")).click();

        driver.findElement(By.xpath("//a[@title='Отправленные']")).click();
        if (driver.findElement(By.xpath("//div[@class='y6']//b[text()='"+emailsubject+"']")) != null)
        {
            System.out.println("Email was sent successfully!");
        }
        else
        {
            System.out.println("Failed to send email");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



        */

    WebDriverWait wait;

    public GmailHomePage (WebDriver driver){

        super(driver);
        wait = new WebDriverWait(driver,30);

    }



    @FindBy(xpath = "//div[@class='z0']/div")
    WebElement composeButton;


    @FindBy(xpath = "//a[@title='Отправленные']")
    WebElement sentEmailsButton;


    @FindBy(xpath = "//div[@class='y6']//b[text()='Email subject']")
    WebElement sentEmailSubject;


    @FindBy(xpath = "//td//img[2]")
    WebElement expandWindow;


    @FindBy(className = "vO")
    WebElement gmailToAddress;


    @FindBy(className = "aoT")
    WebElement gmailSubject;


    @FindBy(css = "div[class='Am Al editable LW-avf']")
    WebElement gmailBody;


    @FindBy(xpath = "//div[text()='Отправить']")
    WebElement sendButton;


    @FindBy(xpath = "//div[@class='oh J-Z-I J-J5-Ji T-I-ax7']/div")
    WebElement trashButton;


    public void pressComposeButton (){

        wait.until(ExpectedConditions.elementToBeClickable(composeButton));
        composeButton.click();

    }

    public void goToSentEmails (){

        sentEmailsButton.click();

    }

    public void verifySendingEmail (){


        if (sentEmailSubject != null)
        {
            System.out.println("Email was sent successfully!");
        }
        else
        {
            System.out.println("Failed to send email");
        }
    }


    public void pressExpandWindow (){

        expandWindow.click();

    }

    public void setToAddress(String addressInput){

        gmailToAddress.sendKeys(addressInput);

    }

    public void setGmailSubject (String subjectInput){

        gmailSubject.sendKeys(subjectInput);

    }

    public void setGmailBody (String bodyInput){

        gmailBody.sendKeys(bodyInput);

    }

    public void pressSendButton (){

        sendButton.click();

    }

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailAlertPage extends AbstractPage {
   /* String expectedError= "Проверьте правильность ввода всех адресов.";
    String actualError= driver.findElement(By.cssSelector("div[class='Kj-JD-Jz']")).getAttribute("innerHTML");
        System.out.println(String.format("Error message: %s", actualError));
        Assert.assertTrue(actualError.contains(expectedError));

    // 5. Click “OK” & enter correct email address & click send

        driver.findElement(By.cssSelector("button[name='ok']")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);*/

    public GmailAlertPage (WebDriver driver){

        super(driver);
    }


    @FindBy(css = "div[class='Kj-JD-Jz']")
    WebElement alertMessage;


    @FindBy(css = "button[name='ok']")
    WebElement okButton;


    public String getAlertMessage (){

        return alertMessage.getAttribute("innerHTML");

    }

    public void pressOkButton (){

        okButton.click();

    }
}

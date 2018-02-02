import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage extends  AbstractPage {

    WebDriverWait wait;

    public GmailLoginPage (WebDriver driver){

        super(driver);
        wait = new WebDriverWait(driver,30);

    }


    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement gmailAddress;


    @FindBy(id = "identifierNext")
    WebElement addressNext;


    @FindBy(xpath = "//input[@name='password']")
    private WebElement gmailPassword;


    @FindBy(id = "passwordNext")
    WebElement passwordNext;


    @FindBy(css = "a[class='WaidBe']")
    WebElement gmailLogo;


    public void setGmailAddress(String addressInput){

        gmailAddress.sendKeys(addressInput);

    }

    public void pressAddressNextButton (){

        addressNext.click();

    }


    public void setGmailPassword(String passwordInput){

        gmailPassword.sendKeys(passwordInput);

    }

    public void pressPasswordNextButton (){

        wait.until(ExpectedConditions.elementToBeClickable(passwordNext));
        passwordNext.click();

    }

    public void goToGmail (){

        gmailLogo.click();

    }

}

package Task2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id= "identifierId")
    private WebElement loginInput;
    @FindBy(id= "identifierNext")
    private WebElement loginNextButton;
    @FindBy(xpath = ".//*[@id='password']//descendant::input")
    private WebElement pathwordInput;
    @FindBy(id= "passwordNext")
    private WebElement pathwordNextButton;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void typeLogin(String login){
        loginInput.sendKeys(login);
        loginNextButton.click();
    }
    public WebElement getPassword(){
        return pathwordInput;
    }
    public void typePassword(String password){
        pathwordInput.sendKeys(password);
        pathwordNextButton.click();
    }
}
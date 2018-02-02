import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//input[@type=\'email\']")
    private WebElement loginInput;

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement nextButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void typeLogin(String login) {
        loginInput.sendKeys(login);
        nextButton.click();
    }

    public WebElement getLoginVisible() {
        return loginInput;
    }
}

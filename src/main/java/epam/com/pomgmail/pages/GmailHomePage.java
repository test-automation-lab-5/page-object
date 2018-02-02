package epam.com.pomgmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GmailHomePage extends InitElementsClass {

    @FindBy(xpath="//div[contains(@class, 'UI')]//table//tr[1]//td[4]")
    private WebElement importantOne;

    @FindBy(xpath="//div[contains(@class, 'UI')]//table//tr[2]//td[4]")
    private WebElement importantTwo;

    @FindBy(xpath="//div[contains(@class, 'UI')]//table//tr[3]//td[4]")
    private WebElement importantThree;

    @FindBy(xpath="//div[contains(@role, 'tabpanel')]//span[contains(@class, 'bog')] | " +
            "//div[contains(@role, 'tabpanel')]//span[contains(@class, 'bog')]//b")
    private List<WebElement> inboxesSubject;

    @FindBy(xpath="//div[@class='TK']//a[contains(@href, 'imp')]")
    private WebElement importantLink;

    @FindBy(xpath="//div[contains(@class, 'AO')]//div[@role='main']//div[@role='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath="//div[contains(@role, 'main')]//span[contains(@class, 'bog')] | //div[contains(@role, 'main')]//span[contains(@class, 'bog')]//b")
    private List<WebElement> importantSubject;

    @FindBy(xpath="//div[@gh='mtb']//div[@act='10']")
    private WebElement deleteBtn;

    @FindBy(xpath="//span[contains(@gh, 'mll')]")
    private WebElement moreBtn;

    @FindBy(xpath="//div[@class='TK']//a[contains(@href, 'trash')]")
    private WebElement trashBtn;

    @FindBy(xpath="//div[@role='main']//div[contains(@gh, 'tl')]//span[contains(@class, 'bog')] | div[@role='main']//div[contains(@gh, 'tl')]//span[contains(@class, 'bog')]//b")
    private List<WebElement> deleteSubject;

    public void initElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void setMessageImportant(){
        importantOne.click();
        importantTwo.click();
        importantThree.click();
    }

    public List<String> getInboxSubject(WebDriver driver){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'UI')]//div[contains(@role, 'tabpanel')]//span[contains(@class, 'bog')]")));

        List<String> titleList = new ArrayList<String>();
        titleList.add(inboxesSubject.get(0).getText());
        titleList.add(inboxesSubject.get(1).getText());
        titleList.add(inboxesSubject.get(2).getText());
        return titleList;
    }

    public void clickImportantLink(){
        importantLink.click();
    }

    public void checkMessages(WebDriver driver){
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'AO')]//div[contains(@role, 'main')]//div[@role='checkbox']")));
        checkboxes.get(0).click();
        checkboxes.get(1).click();
        checkboxes.get(2).click();
    }

    public List<String> getImportantSubject(WebDriver driver){
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'AO')]//div[contains(@role, 'main')]//span[contains(@class, 'bog')]")));

        List<String> verifyList = new ArrayList<String>();
        verifyList.add(importantSubject.get(0).getText());
        verifyList.add(importantSubject.get(1).getText());
        verifyList.add(importantSubject.get(2).getText());
        return verifyList;
    }

    public void clickDeleteAndMoreLinks(){
        deleteBtn.click();
        moreBtn.click();
    }

    public WebElement clickTrashLink(){
        trashBtn.click();
        return trashBtn;
    }

    public List<String> getDeletedSubject(){
        List<String> deletedList = new ArrayList<String>();
        for(int i=0; i<deleteSubject.size(); i++) {
            deletedList.add(deleteSubject.get(i).getText());
        }
        return deletedList;
    }
}

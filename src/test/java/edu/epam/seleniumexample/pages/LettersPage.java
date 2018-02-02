package edu.epam.seleniumexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LettersPage extends AbstractPage{
  //  @FindBy(xpath = "//div[contains(@class, 'TK')]//div[contains(@class, 'aim')]//a")
    @FindBy(xpath = "//a[contains(@href,'https://mail.google.com/mail/u/0/#imp')]")
    private WebElement importantLettersButton;

    @FindBy(xpath = "//tr[contains(@class,'zA')]//td[contains(@class,'WA xY')]")
    private List<WebElement> importantSignList;

    @FindBy(xpath = "//div[@role='tabpanel']//tr[contains(@class,'zA')]//span[contains(@class,'bog')]")
    private List<WebElement> letterTitleList;

    @FindBy(xpath = "//div[contains(@role,'main')]//span[contains(@class,'bog')]")
    private List<WebElement> importantLetterTitleList;

    @FindBy(xpath = "//div[contains(@role,'main')]//span[contains(@class,'bog')]")
    private WebElement marker;

    public LettersPage(WebDriver driver) {
        super(driver);
    }

//    public LettersPage(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//    }

    public List<String> markImportantLetterAndGetMarkedTitles(int quantity) {
        List<String> markedTitles = new ArrayList<String>();
        for (int i = 0; i < quantity; i++) {
            importantSignList.get(i).click();
            markedTitles.add(letterTitleList.get(i).getText());
        }
        return markedTitles;
    }

    public List<String> getLetterTitle(){
        List<String> expectedTitles = new ArrayList<String>();
        for(int i=0; i<letterTitleList.size(); i++ ){
            expectedTitles.add(letterTitleList.get(i).getText());
        }
        return expectedTitles;
    }

    public List<String> getImportantLetterTitle(){

        List<String> importantLetterTitles = new ArrayList<String>();
        for(int i=0; i< importantLetterTitleList.size(); i++) {
            importantLetterTitles.add(importantLetterTitleList.get(i).getText());
        }
        return importantLetterTitles;
    }

    public void clickImportantLettersButton(){
        importantLettersButton.click();
    }

    public WebElement getImportantLettersButton() {
        return importantLettersButton;
    }

    public List<WebElement> getImportantSignList() {
        return importantSignList;
    }

    public List<WebElement> getLetterTitleList() {
        return letterTitleList;
    }

    public List<WebElement> getImportantLetterTitles(){
        return importantLetterTitleList;
    }

    public WebElement getMarker(){
        return marker;
    }
}

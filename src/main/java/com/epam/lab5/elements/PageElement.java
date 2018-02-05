package com.epam.lab5.elements;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import java.util.Arrays;
import java.util.List;

public class PageElement implements WebElement {

    Logger logger = Logger.getLogger(getClass());

    private WebElement webElement;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public PageElement(WebElement webElement) {
        this.webElement = webElement;
    }

    @Override
    public void click() {
        logger.info("Click on : " + name);
        webElement.click();
    }

    @Override
    public void submit() {
        logger.info("Submit : " + name);
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        logger.info("sendKeys : " + Arrays.toString(charSequences) + " to : " + name);
        webElement.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        webElement.clear();
    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return webElement.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List findElements(By by) {
        return null;
    }

    @Override
    public PageElement findElement(By by) {
        return new PageElement(webElement.findElement(by));
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String s) {
        return webElement.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return webElement.getScreenshotAs(outputType);
    }


    public boolean exists() {
        logger.info("Check if [" + name + "] exists ...");
        try {
            String innerHTML = webElement.getAttribute("innerHTML");
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}

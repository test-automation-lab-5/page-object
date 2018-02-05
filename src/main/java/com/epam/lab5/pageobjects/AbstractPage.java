package com.epam.lab5.pageobjects;

import com.epam.lab5.elements.Name;
import com.epam.lab5.elements.PageElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

   static WebDriver driver = new ChromeDriver(){
        {
            manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

    };

    public AbstractPage() {
        this.driver = driver;
        PageFactory.initElements(
                new MyFieldDecorator(
                new DefaultElementLocatorFactory(driver)
        ), this);
    }
}

class MyFieldDecorator extends DefaultFieldDecorator {

    public MyFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {

        ElementLocator locator = factory.createLocator(field);

        if (PageElement.class.isAssignableFrom(field.getType()))
        {
            final PageElement pageElement = new PageElement(proxyForLocator(loader, locator));

            if(field.isAnnotationPresent(Name.class))
            {

                final Name annotationName = field.getAnnotation(Name.class);

                if (!annotationName.value().isEmpty())
                {
                    pageElement.setName(annotationName.value());
                }
            }

            return pageElement;
        }

        else
        {
            return super.decorate(loader, field);
        }
    }
}
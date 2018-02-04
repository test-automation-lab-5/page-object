package com.epam.lab.pagefactory;

import com.epam.lab.pagefactory.driver.DriverObject;
import com.epam.lab.pagefactory.pages.GmailPage;
import com.epam.lab.pagefactory.pages.LoginPage;
import com.epam.lab.pagefactory.testdata.JAXB;
import com.epam.lab.pagefactory.testdata.UnMarshell;
import com.epam.lab.pagefactory.testdata.xmlmodel.TestMessage;
import com.epam.lab.pagefactory.testdata.xmlmodel.User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;
import java.io.File;

import java.io.IOException;
import java.util.List;

public class GmailTest {
    private static WebDriver driver;
    private TestMessage message;
    private List<User> usersList;

    @BeforeClass
    public void launch() throws IOException {

        driver = DriverObject.getDriver();
        File usersXml = new File("src\\\\main\\\\java\\\\com\\\\epam\\\\lab\\\\pagefactory\\\\testdata\\\\users.xml");
        message = UnMarshell.unmarshaller();
        try{
            usersList = JAXB.unmarshal(usersXml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGmail() {
        LoginPage loginPage;
        if(!usersList.isEmpty()) {
            driver.get(usersList.get(0).getSignin());
            loginPage = new LoginPage(driver);
            loginPage.login(usersList.get(0).getEmail());
            loginPage.setPassword(usersList.get(0).getPassword());
            loginPage.openGmail();
        }

        GmailPage gmailPage = new GmailPage(driver);
        Assert.assertNotNull(gmailPage.getComposeCheck());
        gmailPage.sendMessage(message.getReceiver(), message.getSubject(), message.getMessage());
        gmailPage.goToSentFolder();
        gmailPage.removeLetter();

        Assert.assertEquals(gmailPage.getMovedToTrashMessage(), "The conversation has been moved to the Trash.");
       }

    @AfterClass
    public static void quitBrowser(){
        try{
            driver.close();
        }finally{
        driver.quit();
        }
    }
}


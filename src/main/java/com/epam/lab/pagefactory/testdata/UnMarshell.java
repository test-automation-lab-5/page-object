package com.epam.lab.pagefactory.testdata;

import com.epam.lab.pagefactory.testdata.xmlmodel.TestMessage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class UnMarshell {
    public static TestMessage unmarshaller() {
        try {

            File file = new File("src\\\\main\\\\java\\\\com\\\\epam\\\\lab\\\\pagefactory\\\\testdata\\\\testdata.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(TestMessage.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            TestMessage message = (TestMessage) jaxbUnmarshaller.unmarshal(file);
            return message;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
package com.epam.lab.pagefactory.testdata;

import com.epam.lab.pagefactory.testdata.xmlmodel.User;
import com.epam.lab.pagefactory.testdata.xmlmodel.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JAXB {
    public static void marshal(List<User> users, File selectedFile) throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));
        context = JAXBContext.newInstance(Users.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(new Users(users), writer);
        writer.close();
    }

    public static List<User> unmarshal(File importFile) throws JAXBException {
        Users usersData;
        JAXBContext context = JAXBContext.newInstance(Users.class);
        Unmarshaller um = context.createUnmarshaller();
        usersData = (Users) um.unmarshal(importFile);
        return usersData.getUsers();
    }
}
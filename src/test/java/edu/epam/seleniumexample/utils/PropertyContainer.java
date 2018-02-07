package edu.epam.seleniumexample.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyContainer {

    public static final String PATH_TO_PROPERTIES = "src/test/resources/tests.properties";

    public static String driverType;
    public static String driverPath;
    public static String startPage;

    public static String login;
    public static String password;

    public static void loadProperties() {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            properties.load(fileInputStream);
            driverType = properties.getProperty("driverType");
            driverPath = properties.getProperty("driverPath");
            startPage = properties.getProperty("startPage");

            login = properties.getProperty("login");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

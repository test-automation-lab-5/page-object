package com.epam.task2.preferences;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class PreferencesTestGmail extends PreferencesLoader {
    private static final Logger log = Logger.getLogger(PreferencesTestGmail.class);

    private String driverType = null;
    private String driverURL = null;
    private String userMail = null;
    private String userPassword = null;
    private Integer elementsCount = null;
    private Integer implicitlyWait = null;
    private Integer timeOutInSeconds = null;

    @Override
    public void loadPreferences(String preferencesFileURL) throws IOException, PreferencesLoadException {
        try {
            prop = new Properties();
            prop.load(PreferencesTestGmail.class.getResourceAsStream(preferencesFileURL));
            driverType = loadProperty("driverType");
            driverURL = loadProperty("driverURL");
            userMail = loadProperty("userMail");
            userPassword = loadProperty("userPassword");
            elementsCount = Integer.parseInt(loadProperty("elementsCount"));
            implicitlyWait = Integer.parseInt(loadProperty("implicitlyWait"));
            timeOutInSeconds = Integer.parseInt(loadProperty("timeOutInSeconds"));
        } catch (IOException | PreferencesLoadException exception) {
            log.error(exception.getMessage());
            throw exception;
        }
    }

    public String getDriverType() {
        return driverType;
    }

    public String getDriverURL() {
        return driverURL;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Integer getElementsCount() {
        return elementsCount;
    }

    public Integer getImplicitlyWait() {
        return implicitlyWait;
    }

    public Integer getTimeOutInSeconds() {
        return timeOutInSeconds;
    }
}
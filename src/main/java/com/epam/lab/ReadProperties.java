package com.epam.lab;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    private Properties prop = null;

    void readPropertiesFile(String propertyFileName) {
        prop = new Properties();
        try {
            InputStream input = new FileInputStream( propertyFileName );
            prop.load( input );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String getPropertyValue(String key) {
        return prop.getProperty( key );
    }

}


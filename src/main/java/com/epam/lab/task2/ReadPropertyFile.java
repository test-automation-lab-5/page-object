package com.epam.lab.task2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {
    public static String readProperties(String prop){
        Properties properties = new Properties();
        InputStream input = null;
        String value = null;
        try{
            input = new FileInputStream("src\\\\main\\\\resources\\\\test.properties");
            properties.load(input);

          value = properties.getProperty(prop);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }
}

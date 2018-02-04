package com.epam.lab.pagefactory.propertyreader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
    private static final String FILE_PATH = "src\\\\main\\\\resources\\\\test.properties";
    private Properties properties;

    public ReadPropertyFile() throws IOException {
        properties = new Properties();
        FileInputStream input = new FileInputStream(FILE_PATH);
        properties.load(input);
    }

    public String readDriverPath(){
        return properties.getProperty("webdriver.chrome.driver");
    }

    public String readChromeDriver(){
        return properties.getProperty("chromedriver.exe");
    }


}

package com.epam.lab5.propdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.epam.lab5.consts.Paths.LOGIN_PROP_FILE_PATH;

public class LoginDataReader {
    private Properties properties = new Properties();

    public LoginDataReader() throws IOException {
        FileInputStream inputStream = new FileInputStream(LOGIN_PROP_FILE_PATH);
        properties.load(inputStream);
        inputStream.close();
    }

    public String getMailLink() {
        return properties.getProperty("mail.link");
    }

    public String getMailAddress(){
        return properties.getProperty("mail.address");
    }

    public String getMailPassword(){
        return properties.getProperty("mail.password");
    }
}

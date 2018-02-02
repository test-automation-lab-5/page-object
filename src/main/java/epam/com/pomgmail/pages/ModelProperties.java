package epam.com.pomgmail.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ModelProperties {
    private String login;
    private String password;
    private String url;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public void setProperties(){
        Properties prop = new Properties();
        InputStream file = null;
        try {
            file = new FileInputStream("data.properties");
            prop.load(file);

            login = (prop.getProperty("LOGIN"));
            password = (prop.getProperty("PASSWORD"));
            url = (prop.getProperty("URL"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

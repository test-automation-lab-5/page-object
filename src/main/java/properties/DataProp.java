package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class DataProp {
    private Random random = new Random();
    private Properties properties = new Properties();

    public DataProp() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/data.properties");
        properties.load(fileInputStream);
    }

    public String driver() {
        return properties.getProperty("driver");
    }

    public String driverPath() {
        return properties.getProperty("driverPath");
    }

    public String getURL() {
        return properties.getProperty("url");
    }

    public String getMail() {
        return properties.getProperty("mail");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getMailTo() {
        return properties.getProperty("mailTo");
    }

    public String getMailCc() {
        return properties.getProperty("mailCc");
    }

    public String getMailBcc() {
        return properties.getProperty("mailBcc");
    }

    public String generateSubject() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            string.append((char) (random.nextInt(78) + 48));
        }
        return string.toString();
    }

    public String generateMessage() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            string.append((char) (random.nextInt(78) + 48));
        }
        return string.toString();
    }
}

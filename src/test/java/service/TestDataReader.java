package service;
import java.io.InputStream;
import java.util.Properties;
public class TestDataReader {
    private static Properties properties;

    public TestDataReader() {
        properties = new Properties();
        try (InputStream inputStream = TestDataReader .class.getResourceAsStream("/data.properties")) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
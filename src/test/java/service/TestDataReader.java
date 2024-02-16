package service;
import java.io.InputStream;
import java.util.Properties;
public class TestDataReader {
    private static Properties properties;

    private TestDataReader() {
        properties = new Properties();
        try (InputStream inputStream = TestDataReader .class.getResourceAsStream("/data.properties")) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
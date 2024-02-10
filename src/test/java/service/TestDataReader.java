package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class TestDataReader {
    private static final TestDataReader instance = new TestDataReader();
    private static Properties properties;

    private TestDataReader() {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/java/service/data.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TestDataReader getInstance() {
        return instance;
    }


    public static String getProperty(String key) {
        return properties.getProperty(key);
    }


}
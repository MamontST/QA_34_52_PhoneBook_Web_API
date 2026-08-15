package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static String getProperty(String filename, String key) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/properties" + File.separator + filename)) {
            properties.load(fis);
            return properties.getProperty(key);
        } catch (IOException e) {
            System.out.println("Error in reading properties file");
            e.printStackTrace();
            return null;
        }
    }
}

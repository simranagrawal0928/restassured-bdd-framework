package org.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();
    static {
        // This block runs once when the class is first loaded
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Cannot load config.properties", e);
        }
    }
    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        return get("base.url");
    }
}

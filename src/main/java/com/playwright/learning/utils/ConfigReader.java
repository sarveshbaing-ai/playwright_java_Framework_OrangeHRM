package com.playwright.learning.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    // This block runs once when ConfigReader is first used
    static {
        try {
            FileInputStream file = new FileInputStream(
                "src/main/resources/config.properties"
            );
            properties.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException("config.properties file not found: " + e.getMessage());
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getUsername() {
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }
}

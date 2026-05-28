package com.playwright.learning.base;

import com.microsoft.playwright.*;
import com.playwright.learning.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeMethod
    public void setup() {

        // Start Playwright
        playwright = Playwright.create();

        // Launch browser
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(500)
        );

        // Create page
        page = browser.newPage();

        // Open application — URL comes from config.properties
        page.navigate(ConfigReader.getUrl());
    }

    @AfterMethod
    public void tearDown() {

        browser.close();
        playwright.close();
    }
}
package com.playwright.learning.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Page;
import com.playwright.learning.utils.ConfigReader;


public class playwright_Test {
    public static void main(String[] args) {
   

    Playwright pw;
    Browser browser;
    Page page;

    
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        page = browser.newPage();
        page.navigate(ConfigReader.getUrl());

        page.close();
        browser.close();    

    }

                  
}
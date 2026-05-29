package com.playwright.learning.tests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Page;
import com.playwright.learning.pages.LoginPage;
import com.playwright.learning.utils.ConfigReader;


public class LoginToORangeHRM {
    @Test
    public void browserLaunchTest() {
   

    Playwright pw;
    Browser browser;
    Page page;

    
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        page = browser.newPage();
        page.navigate(ConfigReader.getUrl());

           LoginPage loginpage=new LoginPage(page);
           loginpage.loginToOrangeHrm(ConfigReader.getUsername(), ConfigReader.getPassword());
        
        page.close();
        browser.close();    

    }

                  
}




package com.playwright.learning.tests;
import com.playwright.learning.base.BaseTest;
import com.playwright.learning.pages.LoginPage;

import org.testng.annotations.Test;
public class LoginTest extends BaseTest {

    @Test
    public void openOrangeHRM(){

        LoginPage loginPage=new LoginPage(page);
        loginPage.loginToOrangeHrm("Admin","admin123");
        System.out.println("Website Open Successfully");
        page.waitForTimeout(5000);
    }
    

    

}

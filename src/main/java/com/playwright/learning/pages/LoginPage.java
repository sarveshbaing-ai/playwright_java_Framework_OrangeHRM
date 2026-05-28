package com.playwright.learning.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class LoginPage {

    Page page;

    Locator username;
    Locator password;
    Locator login;
    Locator resetPwd;
    public LoginPage(Page page){

        this.page = page;

        username = page.locator("//input[@name='username']");
        password = page.locator("//input[@name='password']");
        login = page.locator("//button[contains(.,'Login')]");
        resetPwd= page.locator("//p[contains(.,'Forgot your password?')]");
    }

    public void enterUsername(String user){
        username.fill(user);

    }
    public void enterPassword(String pwd){
        password.fill(pwd);
    }
    public void clickLogin(){
        login.click();
    }
    public void loginToOrangeHrm(String user,String pwd){
        username.fill(user);
        password.fill(pwd);
        login.click();
        
        
    }
}
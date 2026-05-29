package com.playwright.learning.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.Locator;

public class LoginPage {

    Page page;

    Locator username;
    Locator password;
    Locator login;
    Locator resetPwd;
    public LoginPage(Page page){

        this.page = page;

        username=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username"));
        password=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password"));
        login=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
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


        
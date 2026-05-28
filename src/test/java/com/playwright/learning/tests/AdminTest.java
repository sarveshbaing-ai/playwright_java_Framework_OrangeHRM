package com.playwright.learning.tests;

import com.playwright.learning.base.BaseTest;
import com.playwright.learning.pages.AdminPage;
import com.playwright.learning.pages.LoginPage;
import com.playwright.learning.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

    @Test
    public void addNewUserHappyFlow() {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginToOrangeHrm(ConfigReader.getUsername(), ConfigReader.getPassword());
        page.waitForURL("**/dashboard/index");
        System.out.println("Step 1 PASSED: Login successful");

        // Step 2: Click Admin in nav
        page.locator("//a[contains(@class,'oxd-main-menu-item') and normalize-space()='Admin']").click();
        page.waitForURL("**/admin/viewSystemUsers");
        AdminPage adminPage = new AdminPage(page);
        Assert.assertEquals(adminPage.getPageHeading(), "Admin",
                "Admin page did not load");
        System.out.println("Step 2 PASSED: Admin page loaded");

        // Step 3: Click Add button
        adminPage.clickAddButton();
        page.waitForURL("**/admin/saveSystemUser");
        System.out.println("Step 3 PASSED: Add User form opened");

        // Step 4: Fill in the form
        adminPage.selectUserRole("Admin");
        adminPage.selectStatus("Enabled");
        adminPage.enterEmployeeName("Admin");
        adminPage.enterUsername("testuser_" + System.currentTimeMillis());
        adminPage.enterPassword("Admin@1234");
        adminPage.enterConfirmPassword("Admin@1234");
        System.out.println("Step 4 PASSED: Form filled");

        // Step 5: Click Save
        adminPage.clickSave();
        page.waitForURL("**/admin/viewSystemUsers");
        System.out.println("Step 5 PASSED: User saved successfully");

        // Step 6: Verify user list is displayed
        int resultCount = adminPage.getSearchResultCount();
        Assert.assertTrue(resultCount > 0, "User list is empty after save");
        System.out.println("Step 6 PASSED: User list has " + resultCount + " records");

        System.out.println("Admin Happy Flow completed successfully!");
    }
}

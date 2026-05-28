package com.playwright.learning.tests;

import com.playwright.learning.base.BaseTest;
import com.playwright.learning.pages.LoginPage;
import com.playwright.learning.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test
    public void verifyDashboardAfterLogin() {

        // Step 1: Login — credentials come from config.properties
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginToOrangeHrm(ConfigReader.getUsername(), ConfigReader.getPassword());

        // Step 2: Wait for dashboard to load
        page.waitForURL("**/dashboard/index");

        // Step 3: Verify dashboard heading is visible
        String dashboardHeading = page.locator("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]")
                                      .textContent()
                                      .trim();

        System.out.println("Dashboard heading: " + dashboardHeading);

        Assert.assertEquals(dashboardHeading, "Dashboard",
                "User did not land on Dashboard. Actual heading: " + dashboardHeading);

        System.out.println("Dashboard verification successful!");
    }
}

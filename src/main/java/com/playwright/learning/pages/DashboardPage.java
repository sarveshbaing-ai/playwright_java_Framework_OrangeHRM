package com.playwright.learning.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardPage {

    private Page page;

    // ── Header ───────────────────────────────────────────────────────────────
    private Locator userDropdown;

    // ── Side Navigation ──────────────────────────────────────────────────────
    private Locator navAdmin;
    private Locator navPIM;
    private Locator navLeave;
    private Locator navTime;
    private Locator navRecruitment;
    private Locator navMyInfo;
    private Locator navPerformance;
    private Locator navDashboard;
    private Locator navDirectory;
    private Locator navMaintenance;
    private Locator navClaim;
    private Locator navBuzz;

    // ── Dashboard Widgets ────────────────────────────────────────────────────
    private Locator widgetTimeAtWork;
    private Locator widgetMyActions;
    private Locator widgetQuickLaunch;
    private Locator widgetBuzzLatestPosts;
    private Locator widgetEmployeesOnLeave;
    private Locator widgetEmployeeDistributionSubUnit;
    private Locator widgetEmployeeDistributionLocation;

    public DashboardPage(Page page) {
        this.page = page;

        // Header — user dropdown uses class oxd-userdropdown-tab
        userDropdown = page.locator("//span[contains(@class,'oxd-userdropdown-tab')]");

        // Side nav — all nav links use class "oxd-main-menu-item"
        navAdmin       = page.locator("//a[contains(@class,'oxd-main-menu-item') and normalize-space()='Admin']");
        navPIM         = page.locator("//a[contains(@class,'oxd-main-menu-item') and normalize-space()='PIM']");
        navLeave       = page.locator("//a[contains(@class,'oxd-main-menu-item') and normalize-space()='Leave']");
        navTime        = page.locator("//a[contains(@class,'oxd-main-menu-item') and normalize-space()='Time']");
        navRecruitment = page.locator("//a[contains(@class,'oxd-main-menu-item') and normalize-space()='Recruitment']");
        navMyInfo      = page.locator("//a[contains(@class,'oxd-main-menu-item') and normalize-space()='My Info']");
        navPerformance = page.locator("//a[contains(@class,'oxd-main-menu-item') and normalize-space()='Performance']");
        navDashboard   = page.locator("//a[contains(@class,'oxd-main-menu-item') and normalize-space()='Dashboard']");
        navDirectory   = page.locator("//a[contains(@class,'oxd-main-menu-item') and normalize-space()='Directory']");
        navMaintenance = page.locator("//a[contains(@class,'oxd-main-menu-item') and normalize-space()='Maintenance']");
        navClaim       = page.locator("//a[contains(@class,'oxd-main-menu-item') and normalize-space()='Claim']");
        navBuzz        = page.locator("//a[contains(@class,'oxd-main-menu-item') and normalize-space()='Buzz']");

        // Widgets — widget names use class "orangehrm-dashboard-widget-name"
        widgetTimeAtWork                   = page.locator("//div[contains(@class,'orangehrm-dashboard-widget-name') and normalize-space()='Time at Work']");
        widgetMyActions                    = page.locator("//div[contains(@class,'orangehrm-dashboard-widget-name') and normalize-space()='My Actions']");
        widgetQuickLaunch                  = page.locator("//div[contains(@class,'orangehrm-dashboard-widget-name') and normalize-space()='Quick Launch']");
        widgetBuzzLatestPosts              = page.locator("//div[contains(@class,'orangehrm-dashboard-widget-name') and normalize-space()='Buzz Latest Posts']");
        widgetEmployeesOnLeave             = page.locator("//div[contains(@class,'orangehrm-dashboard-widget-name') and normalize-space()='Employees on Leave Today']");
        widgetEmployeeDistributionSubUnit  = page.locator("//div[contains(@class,'orangehrm-dashboard-widget-name') and normalize-space()='Employee Distribution by Sub Unit']");
        widgetEmployeeDistributionLocation = page.locator("//div[contains(@class,'orangehrm-dashboard-widget-name') and normalize-space()='Employee Distribution by Location']");
    }

    // ── URL ──────────────────────────────────────────────────────────────────

    public String getCurrentUrl() {
        return page.url();
    }

    // ── Header ───────────────────────────────────────────────────────────────

    public String getLoggedInUsername() {
        return page.locator("//p[contains(@class,'oxd-userdropdown-name')]").textContent().trim();
    }

    // ── Side Navigation ──────────────────────────────────────────────────────

    public boolean isNavAdminVisible()       { return navAdmin.isVisible(); }
    public boolean isNavPIMVisible()         { return navPIM.isVisible(); }
    public boolean isNavLeaveVisible()       { return navLeave.isVisible(); }
    public boolean isNavTimeVisible()        { return navTime.isVisible(); }
    public boolean isNavRecruitmentVisible() { return navRecruitment.isVisible(); }
    public boolean isNavMyInfoVisible()      { return navMyInfo.isVisible(); }
    public boolean isNavPerformanceVisible() { return navPerformance.isVisible(); }
    public boolean isNavDashboardVisible()   { return navDashboard.isVisible(); }
    public boolean isNavDirectoryVisible()   { return navDirectory.isVisible(); }
    public boolean isNavMaintenanceVisible() { return navMaintenance.isVisible(); }
    public boolean isNavClaimVisible()       { return navClaim.isVisible(); }
    public boolean isNavBuzzVisible()        { return navBuzz.isVisible(); }

    // ── Widgets ──────────────────────────────────────────────────────────────

    public boolean isWidgetTimeAtWorkVisible()                   { return widgetTimeAtWork.isVisible(); }
    public boolean isWidgetMyActionsVisible()                    { return widgetMyActions.isVisible(); }
    public boolean isWidgetQuickLaunchVisible()                  { return widgetQuickLaunch.isVisible(); }
    public boolean isWidgetBuzzLatestPostsVisible()              { return widgetBuzzLatestPosts.isVisible(); }
    public boolean isWidgetEmployeesOnLeaveVisible()             { return widgetEmployeesOnLeave.isVisible(); }
    public boolean isWidgetEmployeeDistributionSubUnitVisible()  { return widgetEmployeeDistributionSubUnit.isVisible(); }
    public boolean isWidgetEmployeeDistributionLocationVisible() { return widgetEmployeeDistributionLocation.isVisible(); }
}

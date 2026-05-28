package com.playwright.learning.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AdminPage {

    private Page page;

    // ── User Management page ─────────────────────────────────────────────────
    private Locator addButton;

    // ── Add User form ────────────────────────────────────────────────────────
    private Locator userRoleDropdown;
    private Locator statusDropdown;
    private Locator employeeNameInput;
    private Locator usernameInput;
    private Locator passwordInput;
    private Locator confirmPasswordInput;
    private Locator saveButton;
    private Locator cancelButton;

    // ── Success / result ─────────────────────────────────────────────────────
    private Locator searchUsernameInput;
    private Locator searchButton;
    private Locator tableRows;

    public AdminPage(Page page) {
        this.page = page;

        // User Management page
        addButton = page.locator("//button[normalize-space()='Add']");

        // Add User form fields
        // User Role dropdown — first oxd-select on the form
        userRoleDropdown = page.locator("(//div[@class='oxd-select-text-input'])[1]");

        // Status dropdown — second oxd-select on the form
        statusDropdown = page.locator("(//div[@class='oxd-select-text-input'])[2]");

        // Employee Name — placeholder "Type for hints..."
        employeeNameInput = page.locator("//input[@placeholder='Type for hints...']");

        // Username and password inputs
        usernameInput         = page.locator("(//input[@class='oxd-input oxd-input--active'])[2]");
        passwordInput         = page.locator("(//input[@type='password'])[1]");
        confirmPasswordInput  = page.locator("(//input[@type='password'])[2]");

        // Form buttons
        saveButton   = page.locator("//button[normalize-space()='Save']");
        cancelButton = page.locator("//button[normalize-space()='Cancel']");

        // Search on User Management page
        searchUsernameInput = page.locator("(//input[@class='oxd-input oxd-input--active'])[1]");
        searchButton        = page.locator("//button[normalize-space()='Search']");

        // Results table rows
        tableRows = page.locator("//div[@class='oxd-table-body']//div[@role='row']");
    }

    // ── Actions ──────────────────────────────────────────────────────────────

    public void clickAddButton() {
        addButton.click();
    }

    public void selectUserRole(String role) {
        userRoleDropdown.click();
        page.locator("//div[@role='listbox']//span[normalize-space()='" + role + "']").click();
    }

    public void selectStatus(String status) {
        statusDropdown.click();
        page.locator("//div[@role='listbox']//span[normalize-space()='" + status + "']").click();
    }

    public void enterEmployeeName(String name) {
        employeeNameInput.fill(name);
        // Wait for autocomplete suggestion and click first result
        page.locator("//div[@role='listbox']//span").first().click();
    }

    public void enterUsername(String username) {
        usernameInput.fill(username);
    }

    public void enterPassword(String password) {
        passwordInput.fill(password);
    }

    public void enterConfirmPassword(String password) {
        confirmPasswordInput.fill(password);
    }

    public void clickSave() {
        saveButton.click();
    }

    public void clickCancel() {
        cancelButton.click();
    }

    public void searchByUsername(String username) {
        searchUsernameInput.fill(username);
        searchButton.click();
    }

    public int getSearchResultCount() {
        return tableRows.count();
    }

    public String getPageHeading() {
        return page.locator("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]")
                   .textContent().trim();
    }
}

package com.agi.qa.pages;

import com.agi.qa.core.DriverFactory;
import com.agi.qa.core.WebActions;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebActions action;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.action = new WebActions(driver);
    }
}
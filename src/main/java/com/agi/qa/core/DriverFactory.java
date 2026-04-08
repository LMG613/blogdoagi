package com.agi.qa.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-cache");
            options.addArguments("--disable-application-cache");
            options.addArguments("--disk-cache-size=0");
            options.addArguments("--incognito");

            String isHeadless = System.getProperty("headless", "false");
            if (Boolean.parseBoolean(isHeadless)) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
            }

            WebDriver webDriver = new ChromeDriver(options);
            webDriver.manage().deleteAllCookies();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.set(webDriver);
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
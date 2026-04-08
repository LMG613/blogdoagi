package com.agi.qa.core;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebActions {
    private final WebDriverWait wait;

    public WebActions(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void click(By locator, String nomeDoElemento) {
        Allure.step("Clicando no elemento: " + nomeDoElemento, () ->
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click());
    }

    public void sendKeys(By locator, String text, String nomeDoElemento) {
        Allure.step("Preenchendo o campo '" + nomeDoElemento + "' com o valor: " + text, () -> {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
        });
    }

    public String getText(By locator, String nomeDoElemento) {
        Allure.step("Extraindo texto do elemento: " + nomeDoElemento);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public boolean isVisible(By locator, String nomeDoElemento) {
        Allure.step("Verificando se o elemento '" + nomeDoElemento + "' está visível");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
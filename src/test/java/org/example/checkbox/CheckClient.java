package org.example.checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class CheckClient {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final int seconds = 10;
    public CheckClient(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

    }
    protected void clicker(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    protected String result(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}

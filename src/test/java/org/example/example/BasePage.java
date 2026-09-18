package org.example.example;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@Getter
public abstract class BasePage {
    private final WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected Actions actions;
    private final int seconds = 10;
    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.actions = new Actions(webDriver);
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
    }
    protected void click(By locator) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }
    protected void writeText(By locator, String fieldText) {
        WebElement text = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        text.sendKeys(fieldText);
    }
    protected String getData(By locator) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
    protected String getAttributeData(By locator) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute("value");
    }
}

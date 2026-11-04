package com.example.links.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class LinksParent {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private static final Duration duration = Duration.ofSeconds(10);
    public LinksParent(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().maximize();
        wait = new WebDriverWait(driver, duration);
        actions = new Actions(driver);
    }
    public void clickLink(By xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(xpath)).click();
    }
    public void newTabReturnToCurrent() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if(tabs.size() > 1) {
            driver.switchTo().window(tabs.getLast());
            driver.close();
            driver.switchTo().window(tabs.get(tabs.size() - 2));
            driver.close();
        }
        if(!tabs.isEmpty()) driver.switchTo().window(tabs.getFirst());
    }
    public void linkResponded(By xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(xpath)).click();
    }
    public String actualLink(By xpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(xpath)).getText();
    }
}

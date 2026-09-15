package org.example.selen.configuration;

import lombok.Getter;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@Getter
public class SettingsSelenium implements AfterAllCallback, BeforeAllCallback {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private Actions actions;
    private final int timeOut = 10;
    @Override
    public void beforeAll(@NonNull ExtensionContext context) throws Exception {
         this.driver = new ChromeDriver();
         this.actions = new Actions(driver);
         this.driver.manage().window().maximize();
         this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
         this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
         this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
    }
    @Override
    public void afterAll(@NonNull ExtensionContext context) throws Exception {
       if(this.driver != null) {
           this.driver.quit();
       }
    }
}

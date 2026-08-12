package com.example.configurations;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

@Getter
@Setter
public class ManagerDriver implements AfterAllCallback, BeforeAllCallback {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Configuration configuration;
    private WebDriverWait webDriverWait;
    private ChromeDriver driver;
    private Actions actions;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        this.configuration = new Configuration();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        logger.info("Driver started");
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        if(this.driver != null) {
            this.driver.quit();
            logger.info("Driver quitted");
        } else {
            logger.error("Driver is null");
        }
    }

}

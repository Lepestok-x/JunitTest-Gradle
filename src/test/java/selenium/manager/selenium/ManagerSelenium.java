package selenium.manager.selenium;

import lombok.Getter;
import lombok.NonNull;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ManagerSelenium implements BeforeAllCallback, AfterAllCallback {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Getter
    private WebDriver driver;
    private WebDriverWait wait;
    @Getter
    private Actions actions;
    private static final int waitSeconds = 10;
    @Override
    public void beforeAll(@NonNull ExtensionContext context) throws Exception {
        this.driver = new ChromeDriver();
        this.actions = new Actions(this.driver);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(waitSeconds));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitSeconds));
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(waitSeconds));
        this.logger.info("This is objects, successfully creating");
    }

    public void OpenURL(String url) {
        if(url != null) {
            this.driver.get(url);
        } else {
            this.logger.warn("URL is null");
        }
    }
    public WebDriverWait webDriverWait() {
        return this.wait;
    }

    @Override
    public void afterAll(@NonNull ExtensionContext context) throws Exception {
      if(this.driver != null) {
          this.driver.quit();
          this.logger.info("Chrome exit!");
      }
    }
}

package screenshots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class WebTablesParent {
    private final Logger logger = LoggerFactory.getLogger(WebTablesParent.class);
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private static final Duration time = Duration.ofSeconds(10);
    public WebTablesParent(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(time);
        wait = new WebDriverWait(driver, time);
        actions = new Actions(driver);
    }

    protected String title() {
        return driver.getTitle();
    }

    protected void button(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }
    protected void writeData(By locator, final String field) {
        WebElement write = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        write.sendKeys(field);
    }
    protected void search(By locator, final String search) {
        WebElement searchEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.sendKeys(searchEmail, search).pause(Duration.ofSeconds(2)).perform();
        searchEmail.clear();
    }
    protected void clear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
    }
    protected void buttonSecondary(By locator) {
        if(isActiveSecondary(locator)) {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } else logger.error("Button secondary not active: {}", isActiveSecondary(locator));

    }
    protected int getOf(By locator) {
        String of = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        return Integer.parseInt(of.substring(4).trim());
    }
    private boolean isActiveSecondary(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
    }
    protected void scroll(int scroll) {
        actions.scrollByAmount(0, scroll).perform();
    }
}

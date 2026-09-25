package screenshots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class WebTablesParent {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final Duration time = Duration.ofSeconds(10);
    public WebTablesParent(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(time);
        wait = new WebDriverWait(driver, time);
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
        searchEmail.sendKeys(search);
    }
}

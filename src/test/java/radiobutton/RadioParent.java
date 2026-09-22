package radiobutton;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class RadioParent {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private final int seconds = 10;
    public RadioParent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }
    protected void button(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    protected boolean isActive(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
        } catch (TimeoutException e) {
            return false;
        }
    }
    protected String haveSelected(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}

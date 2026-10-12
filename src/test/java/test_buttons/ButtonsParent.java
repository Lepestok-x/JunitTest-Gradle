package test_buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonsParent {
    private WebDriver driver;
    private final Actions actions;
    private final WebDriverWait wait;
    private static final Duration duration = Duration.ofSeconds(10);
    public ButtonsParent(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().maximize();
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, duration);
    }
    protected void button(Button button, By locator) {
       switch (button) {
           case DOUBLE -> {
               WebElement doubleClick = wait.until(ExpectedConditions.elementToBeClickable(locator));
               actions.doubleClick(doubleClick).build().perform();
           }
           case RIGHT -> {
               WebElement rightClick = wait.until(ExpectedConditions.elementToBeClickable(locator));
               actions.contextClick(rightClick).build().perform();
           }
           case CLICK -> {
               wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
           }
           default -> throw new IllegalArgumentException(String.format("Button not found: %s", button));
       }
    }
    protected String buttonMessage(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}

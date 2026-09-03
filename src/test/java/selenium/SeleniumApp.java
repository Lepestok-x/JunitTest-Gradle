package selenium;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import selenium.manager.selenium.ManagerSelenium;

import java.time.Duration;

@Tag("SE-N1")
@DisplayName("Alert demosite")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeleniumApp {
    private final Logger logger = LoggerFactory.getLogger(SeleniumApp.class);
    @RegisterExtension
    static final ManagerSelenium manager = new ManagerSelenium();

    @Test
    @DisplayName("Open browser")
    void browser() {
        manager.OpenURL("https://demoqa.com/alerts");
        WebDriverWait waitDriver = manager.webDriverWait();
        Actions actions = manager.getActions();
        WebDriver driver = manager.getDriver();

        String id = this.fieldText("alertButton", "");
        this.clickButtonAlert(waitDriver, id);
        this.logger.info("Button click: {}", id);
        this.clickButtonAlert(driver, "ok");
        this.logger.info("Alert accept: {}", id);
        id = this.fieldText("timerAlertButton", "");
        this.clickButtonAlert(waitDriver, actions, id);
        this.clickButtonAlert(driver, "ok");
        id = this.fieldText("confirmButton", "");
        this.clickButtonAlert(waitDriver, id);
        this.clickButtonAlert(driver, "ok");
        String actual = this.getTextResult(waitDriver, this.fieldText("confirmResult", "span"));
        this.clickButtonAlert(waitDriver, id);
        this.clickButtonAlert(driver, "cancel");
        String actualCancel = this.getTextResult(waitDriver, this.fieldText("confirmResult", "span"));
        id = this.fieldText("promtButton", "");
        this.clickButtonAlert(waitDriver, id);
        this.sendMessageAlert(driver, "Hello i'm nigga");

        String result = this.getTextResult(waitDriver, this.fieldText("promptResult", "span"));
        String expected = "You selected Ok";
        String expectedCancel = "You selected Cancel";
        String message = "You entered Hello i'm nigga";
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expectedCancel, actualCancel);
        Assertions.assertEquals(message, result);

    }
    public void clickButtonAlert(WebDriverWait wait, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value))).click();
    }
    public void clickButtonAlert(WebDriverWait wait, Actions actions, String value) {
        WebElement timerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
        actions.click(timerButton).pause(Duration.ofSeconds(5)).perform();
    }
    public void clickButtonAlert(WebDriver driver, String value) {
       switch (value.toUpperCase()) {
           case "OK":
               driver.switchTo().alert().accept();
               break;
           case "CANCEL":
               driver.switchTo().alert().dismiss();
           default:
               this.logger.error("Value not found: {}", value);
       }
    }
    public void sendMessageAlert(WebDriver driver, String message) {
        driver.switchTo().alert().sendKeys(message);
        driver.switchTo().alert().accept();
    }
    public String getTextResult(WebDriverWait wait, String id) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(id))).getText();
    }
    public String fieldText(final String id, String type) {
        if(type.equalsIgnoreCase("span")) {
            return String.format("//span[@id='%s']", id);
        }
        return String.format("//button[@id='%s']", id);
    }
}

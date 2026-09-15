package org.example.selen.configuration.manager;
import lombok.extern.slf4j.Slf4j;
import org.example.selen.configuration.SettingsSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
@Slf4j
public class Manager extends SettingsSelenium {

    public void url(String url) {
        if(url != null) {
            log.info("Browser opened");
            this.getDriver().get(url);
        }
    }
    public void button(String xpath) {
       getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }
    public void buttonExecutorJS(String xpath) {
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }
    public void writeText(String text, String xpath) {
        WebElement write = getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        write.sendKeys(text);
    }
    public boolean isButtonActive(String xpath) {
        return getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isEnabled();
    }
    public int page_of(String xpath) {
        String pageOf = getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText();
        return Integer.parseInt(pageOf.substring(4).trim());
    }
}

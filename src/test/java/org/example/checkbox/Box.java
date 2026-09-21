package org.example.checkbox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Box extends CheckClient {
    private final BigList bigList;
    private final By result = By.xpath("//div[contains(@id, 'result')]");
    public Box(WebDriver driver, BigList bigList) {
        super(driver);
        this.bigList = bigList;
    }
    public Box clickSwitch() {
        for(By locator : bigList.getSwitchers())
            clicker(locator);
        return this;
    }
    public Box clickCheck() {
        clicker(bigList.getCheck());
        return this;
    }
    public Box closeSwitch() {
        for(int i = bigList.getSwitchers().size(); i > 0; i--) {
            By locator = bigList.getSwitchers().get(i - 1);
            clicker(locator);
        }
        return this;
    }
    public Box closeCheck() {
        clicker(bigList.getCheck());
        return this;
    }
    public String resultBox() {
        return result(result);
    }
}

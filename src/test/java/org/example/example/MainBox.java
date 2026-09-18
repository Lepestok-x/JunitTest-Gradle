package org.example.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainBox extends BasePage {
    private final By fullName = By.id("userName");
    private final By email = By.id("userEmail");
    private final By currentAddress = By.id("currentAddress");
    private final By permanentAddress = By.id("permanentAddress");
    private final By submit = By.id("submit");
    private final By name = By.id("name");
    private final By getEmail = By.id("email");
    public MainBox(WebDriver webDriver) {
        super(webDriver);
    }
    public MainBox writeFullName(String text) {
        writeText(fullName, text);
        return this;
    }
    public MainBox writeEmail(String text) {
        writeText(email, text);
        return this;
    }
    public MainBox writeCurrentAddress(String text) {
        writeText(currentAddress, text);
        return this;
    }
    public MainBox writePermanentAddress(String text) {
        writeText(permanentAddress, text);
        return this;
    }
    public MainBox submit() {
        click(submit);
        return this;
    }
    public Data getData() {
        return Data.builder().name(getData(name)).email(getData(getEmail))
                .cur_address(getAttributeData(currentAddress)).per_address(getAttributeData(permanentAddress)).build();
    }
}
